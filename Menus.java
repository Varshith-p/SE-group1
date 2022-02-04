import java.io.File;
import java.util.*;
import java.awt.Desktop;
/**
 * @author : SEGROUP-1
 * @version : 
 */
public class Menus {
    /**
     * Menus
     * This method is used to display the Main menu of the user. There are 7 options available in the main menu 
     * User can select anyone option and the respective menus or screens are displayed based on the selection.
     * @throws Exception if the required files are not avaialble.
     */
    public  void mainMenu() throws Exception {

        Menus menuObj = new Menus();
        BookDatabase bookObj = new BookDatabase();
        AccountMaintenance accountObj = new AccountMaintenance(LibraryCaseStudy.mail);
        System.out.println("\n------MAIN MENU------\n");
        System.out.println("1. Search a Book");
        System.out.println("2. Reserve  Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Help and feedback");
        System.out.println("5. recommend a book");
        System.out.println("6. Account Maintenance");
        System.out.println("7. LogOut");
        System.out.println("Enter your choice:");
        try (Scanner scan = new Scanner(System.in)) {
            int choice2 = Integer.parseInt(scan.nextLine());
            String book;
            System.out.println("\033[H\033[2J");
            System.out.flush();
            switch(choice2){

                case 1 :
                   LibraryCaseStudy.search();
                   break; 
                case 2 :
                    System.out.print("enter the book name : ");
                    book=scan.nextLine();
                    bookObj.reserveBook(book);
                    menuObj.mainMenu();
                    break;
                case 3 :
                    System.out.print("enter the book name  : ");
                    String bookName=scan.nextLine();
                    bookObj.returnABook(bookName);
                    menuObj.mainMenu();
                    break;
                case 4 :
                    File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\Help.txt");
                    Desktop sc= Desktop.getDesktop();
                    if (file.exists())
                        sc.open(file);
                    else{
                        System.out.println("A problem occured");
                    }
                    menuObj.mainMenu();
                    break;
                case 5 :
                    accountObj.recommendBook();
                    menuObj.mainMenu();
                    break;
                case 6 :
                    System.out.println("1. View Book Transaction History");
                    System.out.println("2. View Login and Logout Activity");
                    System.out.println("Enter your choice :");
                    choice2 = Integer.parseInt(scan.nextLine());
                    switch(choice2){
                        case 1 : accountObj.booksHistory();
                                 break;
                        case 2 :
                                 accountObj.displayLoginActivity();
                                 break;
                        default: System.out.println("Invalid choice");
                                 menuObj.mainMenu();
                                 break;

                    }
                    menuObj.mainMenu();
                    break;
                case 7 :
                    AccountMaintenance accobj = new AccountMaintenance(LibraryCaseStudy.mail);
                    accobj.updateLogoutActivity();
                    LibraryCaseStudy.run();
                default : 
                    System.out.println("enter a valid choice ");
                    LibraryCaseStudy.run();
  
            }
        }
    }
    /**
     * This method is used to display the Search Menu to the user. 
     * There are 4 ways to search for a book such as such by title, author name , isbn, publisher name. 
     * Based on the option selected by the user respective details are entered by the user.
     */
    public  void displaySearchMenu(){
        System.out.println("\n---------------------------Search menu---------------------------\n");
        System.out.println("1 - Search by title");
        System.out.println("2 - Search by ISBN number");
        System.out.println("3 - Search by author name");
        System.out.println("4 - Search by publisher");
        System.out.println("5 - Exit");
        
    }
    /**
     * THis method is used to display the Main Menu of the Admin.
     * Admin can perform the activites such as Viewiong student details, view books and their count, search for a book, add a book 
     * and view student book History. This menu can be / is displayed only to the Admin .
     * @throws Exception if the run method in the Librarian class raises an error.
     */
    public void displayAdminMenu() throws Exception{
        System.out.println("\n-----------MAIN MENU-----------");
        System.out.println("1. View Student Details");
        System.out.println("2. View Books");
        System.out.println("3. Search for a book");
        System.out.println("4. Add a Book");
        System.out.println("5. View Student BookHistory");
        System.out.println("6. Display Recommended Books");
        System.out.println("7. view FeedBacks");
        System.out.println("8. Logout");
        Librarian.run();
    }
}
