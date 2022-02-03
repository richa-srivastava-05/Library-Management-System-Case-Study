package libms.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminControlBook {

	public void addBook(int id, String name, String author, int count) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "INSERT INTO books"+"(Book_id,book_name,author,count) values"+"(?,?,?,?);";
		PreparedStatement pmt=con.prepareStatement(sql);
        pmt.setInt(1, id);
        pmt.setString(2, name);
        pmt.setString(3, author);
        pmt.setInt(4, count);
        pmt.executeUpdate();
        System.out.println("Book added successfully.");
		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
	}

	public void deleteBook(int id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "DELETE FROM books WHERE book_id= '"+id+"'";
		Statement stmt =con.createStatement();
		boolean rs=stmt.execute(sql);
        System.out.println("Book deleted successfully.");
		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
		
	}
		

	public void updateBook(int id, String name, String author, int count) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		final String updatequery = "update books set book_name= ?, author=?,count=? where book_id =?;";

		System.out.println(updatequery);
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			PreparedStatement pst = con.prepareStatement(updatequery);
	   pst.setString(1,name);
	   pst.setString(2,author);
	   pst.setInt(3,count);
	   pst.setInt(4,id);
	   pst.executeUpdate();
		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
	}

	public void showAllBook() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("B_ID  NAME  AUTHOR  COUNT");
		System.out.println("-------------------------"); 
		String sql = "SELECT * FROM books";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
           System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4));
           System.out.println("---------------------------------------------------");  
        }
		

		
	}
		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
	}

	public void showRequestTable() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("B_ID  NAME  AUTHOR  U_ID  R_DATE(YYYY/MM/DD)");
		System.out.println("------------------------------------------------"); 
		String sql = "SELECT * FROM book_request";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+" | "+rs.getString(5));
           System.out.println("---------------------------------------------------");
        } 
        }

		catch (SQLException err) {
		    err.printStackTrace();
		 }
		
	}

	public void showAcceptedTable() throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("B_ID  NAME  AUTHOR  U_ID  I_DATE(YYYY/MM/DD)");
		System.out.println("----------------------------------------------");
		String sql = "SELECT * FROM accepted_request";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4)+ " | "+rs.getString(5));
           System.out.println("---------------------------------------------------");
        } 
		
	}

		catch (SQLException err) {
		    err.printStackTrace();
		 }
}

	public void acceptRequest(int id, int u_id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		 int val;
		 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String s="SELECT name,username from users_table where user_id='"+u_id+"'" ;
		Statement stmt =con.createStatement();
		ResultSet r = stmt.executeQuery(s);
		if(r.next())
			{
				String s1="SELECT book_id,user_id from Accepted_request where book_id= '"+id+"'and user_id='"+u_id+"'" ;
				ResultSet r1 = stmt.executeQuery(s);
				if(r1.next())
				{
					System.out.println("Already issued");
				}

				else
			{
			String sql1="SELECT * from BOOKS where book_id= '"+id + "' and count>0";
		
			ResultSet rs = stmt.executeQuery(sql1);
				if(rs.next())
				{
					
					String query="SELECT book_name,author from BOOKS where book_id= '"+id+"'" ;
					ResultSet rs1 = stmt.executeQuery(query);
					String name;
					String author;
				while(rs1.next()) {
					name=rs1.getString(1);
					author=rs1.getString(2);
					String sql = "INSERT INTO accepted_request (book_id,book_name,author,user_id,issued_date) values (?,?,?,?,CURRENT_TIMESTAMP);";
			         PreparedStatement pmt=con.prepareStatement(sql);
			         pmt.setInt(1, id);
			         pmt.setString(2, name);
			         pmt.setString(3, author);
			         pmt.setInt(4, u_id);
			         pmt.executeUpdate();
			      
				}
				String query2="update books set count= count-1 where book_id='"+id +"'";
				boolean rs2=stmt.execute(query2);
				String sql2 ="delete from book_request Where BOOK_ID='" + id  + "' and user_id='" +u_id + "'";
				
		         boolean rs3=stmt.execute(sql2);
		        System.out.println("Request accepted successfully.");
			
				}
				
				else {
					System.out.println("Book not available.");
				}
			}
			}
		else 
		{
			System.out.println("User does not exist");
		 }
		
			}
		
		
	catch (SQLException err) {
	    err.printStackTrace();

	}

}
}
