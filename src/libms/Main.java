package libms;

import java.util.Scanner;

import libms.database.Database;
class Data{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

public class Main extends Database {

	public static void main(String[] args) {
		Data data=new Data();
		Database db=new Database();
		System.out.println("---------**************************************--------------");
		System.out.println("          Welcome to Library Management System");
		System.out.println("---------**************************************---------------");
		System.out.println("Please select an option to continue:");
		System.out.println("1.Press 1 to login as user.");
		System.out.println("2.Press 2 to login as admin.");
		System.out.println("3.Press 3 to exit.");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
		case 1:
		{
			System.out.print("Enter Username: ");
			data.setUsername(sc.next());
			System.out.print("Enter Password: ");
			data.setPassword(sc.next());
			Login login=new Login();
			try {
				login.verifyUser(data.getUsername(),data.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
		case 2:
		{
			System.out.print("Enter Username: ");
			data.setUsername(sc.next());
			System.out.print("Enter Password: ");
			data.setPassword(sc.next());
			Login login=new Login();
			try {
				login.verifyAdmin(data.getUsername(),data.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
		case 3:
		{
			System.out.println("Exiting..");
			return;
			
		}
		default:
				System.out.println("Ivalid selection!Try Again");
				return;
		}
	}

}
