package libms.admin;

import java.util.Scanner;

import libms.admin.user.AdminControl;
import libms.admin.admin.AdminControl2;
class UserData{
	private String name;
	private String username;
	private String password;
	private String email;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void entry() {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter id: ");
		setId(sc.nextInt());
		
		System.out.println("Enter name: ");
		sc.nextLine();
		String name=sc.nextLine();
		setName(name);
		
		System.out.println("Enter username : ");
		setUsername(sc.next());
		
		System.out.println("Enter Password: ");
		setPassword(sc.next());
		System.out.println("Enter email: ");
		setEmail(sc.next());
	}
	
}

public class AdminPage {
	public void main() throws Exception  {
		AdminControl control=new AdminControl();
		AdminControl2 control2=new AdminControl2();
		AdminControlBook control3=new AdminControlBook();
		UserData data=new UserData();

	System.out.println("-----------------------");
	System.out.println("     Admin Menu");
	System.out.println("------------------------");
	while(true) {
	System.out.println("Admin control menu");
	System.out.println("1.Press 1 for User account .");
	System.out.println("2.Press 2 For Admin account");
	System.out.println("3.Press 3 For Books account");
	System.out.println("4.Press 4 Requested book list.");
	System.out.println("5.Press 5 Accepted book list.");
	System.out.println("6.Press 6 to Accept the book request.");
	System.out.println("7.Press 7 Exit.");
	Scanner sc=new Scanner(System.in);
	int option=sc.nextInt();
	switch(option) {
		case 1:
		{
			while(true){
				System.out.println("Please select an option to continue:");
				System.out.println("1.Press 1 to add user .");
				System.out.println("2.Press 2 to delete user");
				System.out.println("3.Press 3 to update user");
				System.out.println("4.Press 4 list all user.");
				System.out.println("5.Press 5 Exit.");
				int input=sc.nextInt();
				switch(input) {
				case 1:
				{
					data.entry();
					control.addUser(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
					break;
				}
				case 2:
				{
					System.out.print("Enter user id: ");
					data.setId(sc.nextInt());
					control.deleteUser(data.getId());
					break;
				}
				
				case 3:
				{
					data.entry();
					control.updateUser(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
				}
				
				case 4:
				{
					control.showAllUser();
					break;
				}
				case 5:
					return;
				default:
				{
					System.out.println("Invalid selection!");
					return;
				}
			}
		}

			}
		case 2:
		{
			while(true)
			{
			System.out.println("Please select an option to continue:");
			System.out.println("1.Press 1 to add admin .");
			System.out.println("2.Press 2 to delete admin");
			System.out.println("3.Press 3 to update admn");
			System.out.println("4.Press 4 list all admin.");
			System.out.println("5.Press 5 Exit.");
			int input=sc.nextInt();
			switch(input) {
			case 1:
			{
				data.entry();
				control2.addAdmin(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
				break;
		}
			case 2:
			{
				System.out.print("Enter admin id: ");
				data.setId(sc.nextInt());
				control2.deleteAdmin(data.getId());
				break;

			}
			
			case 3:
			{
				data.entry();
				control2.updateAdmin(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
				break;
			}
			
			case 4:
			{
				control2.showAllAdmin();
				break;
			}
			case 5:
				return;
			default:
			{
				System.out.println("Invalid selection!");
				return;
			}

		
		}
	}
		}
		case 3:
		{
		while(true){
			System.out.println("Please select an option to continue:");
			System.out.println("1.Press 1 to add book");
			System.out.println("2.Press 2 to delete book");
			System.out.println("3.Press 3 to update book");
			System.out.println("4.Press 4 list all book.");
			System.out.println("5.Press 5 Exit.");
			int input=sc.nextInt();
			switch(input) {
			case 1:
			{
				System.out.print("Enter book id: ");
				sc.nextLine();
				int id=sc.nextInt();
				
				System.out.println("Enter book name: ");
				sc.nextLine();
				String name=sc.nextLine();
				
				System.out.println("Enter author name: ");;
				String author=sc.nextLine();
				
				System.out.println("Enter book count: ");
				int count=sc.nextInt();
				control3.addBook(id,name,author,count);
				break;
			}
			case 2:
			{
				System.out.print("Enter book id: ");
				int id=sc.nextInt();
				control3.deleteBook(id);
				break;
			}
			
			case 3:
			{
				System.out.print("Enter book id: ");
				sc.nextLine();
				int id=sc.nextInt();
				
				System.out.println("Enter book name: ");
				sc.nextLine();
				String name=sc.nextLine();
				
				System.out.println("Enter author name: ");
				String author=sc.nextLine();
				
				System.out.println("Enter book count: ");
				int count=sc.nextInt();
				control3.updateBook(id,name,author,count);
				break;
				
			}
			
			case 4:
			{
				control3.showAllBook();
				break;
			}
			case 5:
				return;
			default:
			{
				System.out.println("Invalid selection!");
				return;
			}
		}
	}
	}
		case 4:
		{
			control3.showRequestTable();
			break;
		}
		case 5:
		{
			control3.showAcceptedTable();
			break;
		}
		case 6:
		{
			System.out.print("Enter book id: ");
			int id=sc.nextInt();
			System.out.println("Enter user id: ");
			int u_id=sc.nextInt();
			control3.acceptRequest(id,u_id);
			break;
		}
		case 7:
		{
			return;
		}
		default:
			return;
	}
}
	}
}



		
