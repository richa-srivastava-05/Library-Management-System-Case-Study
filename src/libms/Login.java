package libms;
import java.sql.*;

import libms.admin.AdminPage;
import libms.user.UserPage;

public class Login {

	public void verifyUser(String username,String password) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        if (username != null && password != null) {
	            String sql = "Select * from users_table Where username='" + username + "' and password='" + password + "'";
	            
	            Statement stmt =con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	               System.out.println("Welcome user "+rs.getString(2));
	               UserPage user=new UserPage();
	               user.main();
	                             
	            } else {
	                System.out.println("Invalid username or password");
	            }
	        }

	    } catch (SQLException err) {
	       err.printStackTrace();
	    }
	}
	public void verifyAdmin(String username,String password) throws Exception {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        if (username != null && password != null) {
	            String sql = "Select * from admin_table Where username='" + username + "' and password='" + password + "'";
	            
	            Statement stmt =con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	               System.out.println("Welcome Admin "+rs.getString(2));
	               
	               AdminPage admin=new AdminPage();
	               admin.main();
	            } else {
	                System.out.println("Invalid username or password");
	            }
	        }

	    } catch (SQLException err) {
	       err.printStackTrace();
	    }
	}

}
