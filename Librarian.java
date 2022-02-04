package SeProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.awt.*;

/**<h1>Librarian<h1>
 * @author : SE GROUP-1
 * @version : 2.0
 * <p>This class contains the methods that can be accessed by the Admin only(Librarian). 
 * Methods in this class are : run, displayStudentDetails, displayBooksData , addBook.
 * These methods are purely accessed only by admin login. 
 * These methods are used to get details of the books available and details of a praticular student and books issued to the student.
 * Librarian can add a new book to the Inventory by entering the details of the book and the copies of the book available.<p>
 */
public class Librarian {
    /**
     * This method is used to take input from the Librarian based on the Menu displayed to him / her.
     * Based on the input respective action/method is called. 
     * @throws Exception
     */
    public static void run() throws Exception{
        Menus menuObj = new Menus();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice :");
        int choice = Integer.parseInt(scan.nextLine());
        System.out.println("\033[H\033[2J");
        System.out.flush();
        Librarian libObj = new Librarian();
        switch(choice){
            case 1:
                System.out.println("1. Display All students Details ");
                System.out.println("2. Display particular Student Details ");
                choice = Integer.parseInt(scan.nextLine());
                switch(choice){
                    case 1 :
                        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\detailsFile.csv");
                        Desktop sc= Desktop.getDesktop();
                        if (file.exists())
                            sc.open(file);
                        else{
                            System.out.println("A problem occured");
                        }
                        menuObj.displayAdminMenu();
                        break;
                    case 2:
                        System.out.println("Enter Student Name :");
                        String name = scan.nextLine();
                        libObj.displayStudentDetails(name);
                        menuObj.displayAdminMenu();
                    default :
                        menuObj.displayAdminMenu();
                }
                break;
            case 2 : 
                System.out.println("Book Name ----------- Copies Available");
                libObj.displayBooksData();
                menuObj.displayAdminMenu();
                break;
            case 3:
                LibraryCaseStudy.search();
                break;
            case 4:
                libObj.addBook();
                menuObj.displayAdminMenu();
                break;
            case 5:
                System.out.println("Enter student email :");
                String email = scan.nextLine();
                AccountMaintenance accobj = new AccountMaintenance(email);
                accobj.booksHistory();
                menuObj.displayAdminMenu();
                break;
            case 6:
                System.out.println("The recommended Books");
                libObj.displayRecommendedBooks();
                menuObj.displayAdminMenu();
            case 7:
                File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\FeedBack.txt");
                Desktop obj = Desktop.getDesktop();
                if(file.exists()){
                    obj.open(file);
                }
                else{
                    System.out.println("File is not available");
                }
                menuObj.displayAdminMenu();
                break;
            case 8:
                LibraryCaseStudy.run();
            default:
                System.out.println("Enter a valid choice ");
                menuObj.displayAdminMenu();
        }
        scan.close();
    }
    /**
     * This method is used to display the student details by entering his name . 
     * Student details such as Name , branch, year of study, email , registration number are displayed. 
     * @param studentName The name of the student whose details have to be displayed.
     * @throws FileNotFoundException The exception is thrown if the File containing the student details is not avaialble.
     */
    public void displayStudentDetails(String studentName) throws FileNotFoundException{
        System.out.println("\033[H\033[2J");
        System.out.flush();
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\detailsFile.csv");
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("\n");
        boolean found= false;
        while(scan.hasNext()){
            String data = scan.next();
            if(!data.equals("")){
                String[] details = data.split(",");
                if(details[0].equals(studentName)){
                    found = true;
                    System.out.println("\n");
                    System.out.println("Student Name        :"  +studentName);
                    System.out.println("Registered Number   :"  +details[1]);
                    System.out.println("Branch              :"  +details[2]);
                    System.out.println("Year of Study       :"  +details[3]);
                    System.out.println("Email id            :"  +details[4]);
                    System.out.println("\n");
                }
            }
        }
        scan.close();
        if(found == false){
            System.out.println("Student Details Not Found");
        }
    }
    /**
     * This method is used to display the books that are available in the Library. 
     * The name of the book and the copies of the book avaialable are displayed. 
     * @throws IOException If the file is not able to open.
     *  
     */
    public void displayBooksData() throws IOException{
        System.out.println("\033[H\033[2J");
        System.out.flush();
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Desktop obj  = Desktop.getDesktop();
        if(file.exists()){
            obj.open(file);
        }
        else{
            System.out.println("File is not available");
        }
        /*System.out.println("\033[H\033[2J");
        System.out.flush();
        File bookFile = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(bookFile);
        scan.useDelimiter("\n");
        System.out.println("\n");
        while (scan.hasNext()) {
            String bookData = scan.next();
            if(!bookData.isEmpty()){
                String[] bookDetails = bookData.split(",");
                String text = String.format("%15s %15s",bookDetails[0],bookDetails[4]);
                System.out.println(text);
                //System.out.printf("%-19s %s%n", bookDetails[0] + " ", bookDetails[4]);
                //System.out.println(bookDetails[0]+" "+bookDetails[4]);
            }                   
        }
        System.out.println("\n");
        scan.close();*/
    }
    /**
     * This method is used by the librarian if he/she wants to add a new book to the Library.
     * Book Details such as name , author name , publisher name , isbn number , copies available are asked.
     * @throws FileNotFoundException This exception is thrown if the file containing the books Data is not available.
     * @throws IOException if the file is not writable.
     */
    public void addBook() throws FileNotFoundException , IOException{
        try{
        System.out.println("\033[H\033[2J");
        System.out.flush();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the BookName :");
        String bookName = scan.nextLine();
        System.out.println("Enter Author name :");
        String authorName = scan.nextLine();
        System.out.println("Enter ISBN Number :");
        String IsbnNumber = scan.nextLine();
        System.out.println("Enter Publisher Name :");
        String publisherName = scan.nextLine();
        System.out.println("Enter available copies :");
        int copies = Integer.parseInt(scan.nextLine());
        String data ="\n"+bookName + "," +authorName +"," + IsbnNumber +","+publisherName+","+copies;
        byte[] b = data.getBytes();
        FileOutputStream fileout = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv",true);
        fileout.write(b);
        fileout.close();
        }
        catch(Exception e){
            System.out.println("File is currently being used by another resource please close it");
        }
    }

    public void displayRecommendedBooks() throws FileNotFoundException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\RecommendedBooks.csv");
        Scanner scan = new Scanner(file);
        String text = "";
        while(scan.hasNext()){
            text = text + scan.next()+"\n";
        }
        String[] data = text.split("\n");
        for(int  i =data.length -1; i>=0;i--){
            if(!data[i].isEmpty()){
                String[] details = data[i].split(",");
                System.out.println("Email            :"  +details[0]);
                System.out.println("BookName         :"  +details[1]);
                System.out.println("AuthorName       :"  +details[2]);
                System.out.println("ISBN number      :"  +details[3]);
                System.out.println("Publisher Name   :"  +details[4]);
                System.out.println("Date             :"  +details[5]);
                System.out.println("---------------------------");
            }
        }
    }
}
