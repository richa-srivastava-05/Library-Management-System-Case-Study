package libms.admin.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminControl {

	public void addUser(int id,String name, String username, String pass, String email) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "INSERT INTO users_table"+"(user_id,name,username,password,email) values"+"(?,?,?,?,?);";
		PreparedStatement pmt=con.prepareStatement(sql);
        pmt.setInt(1, id);
        pmt.setString(2, name);
        pmt.setString(3, username);
        pmt.setString(4, pass);
        pmt.setString(5, email);
        pmt.executeUpdate();
        System.out.println("User added successfully.");
		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
	}


	public void updateUser(int id, String name, String username, String password, String email) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		final String updatequery = "update users_table set name= ?, username=?,password=?,email=? where user_id =?;";

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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void showAllUser() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("ID  NAME  USERNAME  EMAIL");
		System.out.println("-------------------------");  
		String sql = "SELECT * FROM users_table";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(5));
           System.out.println("---------------------------------------------------");      
        } 
        
		

	
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
	}


	public void deleteUser(int id) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "DELETE FROM users_table WHERE user_id= '"+id+"'";
		Statement stmt =con.createStatement();
		boolean rs=stmt.execute(sql);
        System.out.println("User deleted successfully.");
		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
		
	}
	


	
	

}
