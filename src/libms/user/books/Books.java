package libms.user.books;

import java.sql.*;


public class Books {
	public void showBooks() throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		System.out.println("ID  NAME  AUTHOR  COUNT");
		System.out.println("-------------------------");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		   String sql = "Select * from Books";
         
         Statement stmt =con.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4));
            System.out.println("-----------------------------------------------------------------");   
         
         }
		}

  catch (SQLException err) {
    err.printStackTrace();
 }
	}
	
	
	public void requestForIssue(int id,int id2) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String query="SELECT book_id,book_name,author from BOOKS where book_id= "+id ;
		Statement stmt =con.createStatement();
		ResultSet rs1 = stmt.executeQuery(query);
		int book_id;
		String name;
		String author;
		while(rs1.next()) {
			book_id=rs1.getInt(1);
			name=rs1.getString(2);
			author=rs1.getString(3);
			String sql = "INSERT INTO BOOK_REQUEST (book_id,book_name,author,user_id,Requested_date) values (?,?,?,?,CURRENT_TIMESTAMP);";
	         PreparedStatement pmt=con.prepareStatement(sql);
	         pmt.setInt(1, book_id);
	         pmt.setString(2, name);
	         pmt.setString(3, author);
	         pmt.setInt(4, id2);
//	         pmt.setDate(5,);
	         pmt.executeUpdate();
	         System.out.println("Request added successfully.");
		}
	
		}

  catch (SQLException err) {
    err.printStackTrace();
 }
	}


	public void showRequestedBooks(int id) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("B_ID  NAME  AUTHOR  U_ID  R_DATE(YYYY/MM/DD)");
		System.out.println("----------------------------------------------");
		 String sql ="Select * from BOOK_REQUEST Where user_id='" + id + "'";
		 Statement stmt =con.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getDate(5));
            System.out.println("---------------------------------------------------");  
         } 
		
	}

  catch (SQLException err) {
    err.printStackTrace();
		
	}
	
}


	public void showAcceptedBooks(int id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("B_ID  NAME  AUTHOR  U_ID  I_DATE(YYYY/MM/DD)");
		System.out.println("-----------------------------------------------");
		 String sql ="Select * from ACCEPTED_REQUEST Where user_id='" + id  + "'";
		 Statement stmt =con.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
            System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getDate(5));
            System.out.println("-----------------------------------------------------------------");
         }
		}
	
		catch (SQLException err) {
		    err.printStackTrace();
				
			}
	}

	public void returnBook(int book_id, int u_id) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");
		try {
		String sql1="SELECT * from Accepted_request where book_id= '"+book_id + "' and user_id = '"+u_id+"'";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				
				String query2="update books set count= count+1 where book_id='"+book_id +"'";
				boolean rs3=stmt.execute(query2);
				String sql = "delete from Accepted_request where book_id= ? and user_id = ?";
				PreparedStatement pmt=con.prepareStatement(sql);
		         pmt.setInt(1, book_id);
		         pmt.setInt(2, u_id);
		         pmt.executeUpdate();
				 System.out.println("Returned successfully.");
			}
			else {
				System.out.println("Book not issued.");
			}
			      
		
			}
			
			
		catch (SQLException err) {
		    err.printStackTrace();
		}
	}
}
	
