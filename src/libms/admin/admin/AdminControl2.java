package libms.admin.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminControl2 {
	 public void addAdmin(int id,String name, String username, String pass, String email) throws Exception {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "INSERT INTO admin_table"+"(admin_id,name,username,password,email) values"+"(?,?,?,?,?);";
			PreparedStatement pmt=con.prepareStatement(sql);
	     pmt.setInt(1, id);
	     pmt.setString(2, name);
	     pmt.setString(3, username);
	     pmt.setString(4, pass);
	     pmt.setString(5, email);
	     pmt.executeUpdate();
	     System.out.println("Admin added successfully.");
			
		}
			catch (SQLException err) {
			    err.printStackTrace();
			 }
		}
	 
		public void updateAdmin(int id, String name, String username, String password, String email) throws Exception {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
			final String updatequery = "update admin_table set name= ?, username=?,password=?,email=? where admin_id =?;";

			System.out.println(updatequery);
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				PreparedStatement pst = con.prepareStatement(updatequery);
		   pst.setString(1,name);
		   pst.setString(2,username);
		   pst.setString(3,password);
		   pst.setString(4,email);
		   pst.setInt(5,id);
		   pst.executeUpdate();
			
		}
			catch (SQLException err) {
			    err.printStackTrace();
			 }
			
		}

		public void showAllAdmin() throws Exception {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("A_ID  NAME  USERNAME  EMAIL");
			System.out.println("-------------------------"); 
			 
			String sql = "SELECT * FROM admin_table";
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()) {
	           System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(5));
	           System.out.println("---------------------------------------------------");  
	        }
			

			
		}
			catch (SQLException err) {
			    err.printStackTrace();
			 }
			
		}


		public void deleteAdmin(int id) throws Exception{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "DELETE FROM admin_table WHERE admin_id= '"+id+"'";
			Statement stmt =con.createStatement();
			boolean rs=stmt.execute(sql);
	        System.out.println("Admin deleted successfully.");
			
		}
			catch (SQLException err) {
			    err.printStackTrace();
			 }
			
			
		}
		

}
