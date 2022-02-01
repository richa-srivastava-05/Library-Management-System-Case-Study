package libms.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database  {


		public void create_db() throws Exception{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "mysql@richa");

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Statement stm=con.createStatement();
				String sql = "CREATE DATABASE library"; 

		         stm.executeUpdate(sql);	  
		      }
			catch (SQLException e) {
		         e.printStackTrace();
			
		}
		}
		
		
		public void create_table() throws Exception {
			// TODO Auto-generated method stub
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "mysql@richa");

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Statement stm=con.createStatement();
				String sql1 = "CREATE TABLE users_table " +
		                   "(USER_ID Integer not NULL, " +
		                   " NAME VARCHAR(255), " + 
		                   " USERNAME VARCHAR(255), " + 
		                   " PASSWORD VARCHAR(255), " + 
		                   " EMAIL VARCHAR(255), " + 
		                   " PRIMARY KEY ( USER_ID ))"; 
				stm.executeUpdate(sql1);
				String sql2 = "CREATE TABLE admin_table " +
		                   "(ADMIN_ID Integer not NULL, " +
		                   " NAME VARCHAR(255), " + 
		                   " USERNAME VARCHAR(255), " + 
		                   " PASSWORD VARCHAR(255), " + 
		                   " EMAIL VARCHAR(255), " + 
		                   " PRIMARY KEY ( ADMIN_ID ))"; 
				stm.executeUpdate(sql2);
				String sql3 = "CREATE TABLE books " +
		                   "(BOOK_ID Integer not NULL, " +
		                   " BOOK_NAME VARCHAR(255), " + 
		                   " AUTHOR VARCHAR(255), " + 
		                   " COUNT INTEGER not NULL, " + 
		                   " PRIMARY KEY ( BOOK_ID ))"; 
				stm.executeUpdate(sql3);
				String sql4 = "CREATE TABLE book_request " +
		                   "(BOOK_ID Integer not NULL, " +
		                   " BOOK_NAME VARCHAR(255), " + 
		                   " AUTHOR VARCHAR(255) ," +
		                   "USER_ID Integer not NULL,"+
		                   "REQUESTED_DATE DATE not NULL)";
		                       
				stm.executeUpdate(sql4);
				String sql5 = "CREATE TABLE accepted_request " +
		                   "(BOOK_ID Integer not NULL, " +
		                   " BOOK_NAME VARCHAR(255), " + 
		                   " AUTHOR VARCHAR(255) ,"+ 
		                   "USER_ID Integer not NULL,"+
		                   "ISSUED_DATE DATE not NULL)";
       
		   		stm.executeUpdate(sql5);
		         System.out.println("Created table in given database...");   	  
		      }
			catch (SQLException e) {
		         e.printStackTrace();
		}
		}

public static void main(String args[]) throws Exception
		{
			
			Database db=new Database();
//			db.create_db();
			db.create_table();
}
		
		

		
}
