package libms.user;

import java.util.Scanner;

import libms.user.books.Books;



public class UserPage {

	public  void main() throws Exception {
		Books list=new Books();
		
		System.out.println("-----------------------");
		System.out.println("     User Menu");
		System.out.println("------------------------");
		while(true) {
		System.out.println("Please select an option to continue:");
		System.out.println("1.Press 1 to list all books.");
		System.out.println("2.Press 2 Requesting to issue book.");
		System.out.println("3.Press 3 Books Issued List.");
		System.out.println("4.Press 4 to return book.");
		System.out.println("5.Press 5 Exit.");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
		case 1:
		{
			list.showBooks();	
			break;
		}
		
		case 2:
		{
			System.out.println("     Rquested Book Menu");
		
			while(true) {
				System.out.println("Please select an option to continue:");
				System.out.println("1.Press 1 for rising request for issue.");
				System.out.println("2.Press 2 Sow requested book list.");
				System.out.println("3.Press 3 Exit.");
				
				int input=sc.nextInt();
				switch(input) {
				case 1:
				{
					System.out.println("Enter book id for requesting: ");
					int book_id=sc.nextInt();
					System.out.println("Enter your user id: ");
					int user_id=sc.nextInt();
					list.requestForIssue(book_id,user_id);
					break;
				}
				case 2:
				{
						System.out.println("Enter your id: ");
						int id=sc.nextInt();
						list.showRequestedBooks(id);
					
					break;
				}
				case 3:
					return;
					
				default:
					{
					System.out.println("Invalid selection");
					return;
					}
			}
				}
			
			}
		
		case 3:
		{
			System.out.println("Enter your id: ");
			int id=sc.nextInt();
			list.showAcceptedBooks(id);
			break;
		}
		case 4:
		{
			System.out.println("Enter book id for returning: ");
			int book_id=sc.nextInt();
			System.out.println("Enter your user id: ");
			int user_id=sc.nextInt();
			list.returnBook(book_id,user_id);
			break;
		}
		
		
		case 5:
			return;
			
		
		default:
		{
			System.out.println("Ivalid selection!Try Again");
			return;
		}
				
		}
		
		}
	}
	
}
