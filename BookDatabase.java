import java.util.Scanner;
import java.io.*;
import java.io.File;
/**Book Database
 * @author : SEGROUP-1
 * @version : 1.0
 * This class contains the data and methods related to search, reserve and return book by the user and search book by the Admin.
 * The possible ways to search a book are by its name , authorname , isbn number, publisher name . This class contains all those methods
 * along with the returning the book by the user and reserving the book by the user by its name and isbn number.
 */
public class BookDatabase {  
       
    /**
     * This method is used to search the book by using the name given by user.
     * @param title the name of the book(title) to be searched is passed as parameter
     * @throws Exception  if the file booklist.csv is not available.
     */
    public  void searchByTitle(String title) throws Exception {
        
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                if(details[0].equalsIgnoreCase(title)){
                    String bookdetails ="\n"+"Book name :"+details[0]+"\n"+"Author name :"+details[1]+"\n"+"ISBN number :"+details[2]+"\n"+"Publisher :"+details[3];
                    System.out.println(bookdetails);
                    searchResult = 1;
                    
                }
            }
        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();

    }
    /**
     * This method is used to search the book by using the author name given by user.
     * @param author the name of the author is passed as parameter
     * @throws FileNotFoundException if the file booklist.csv is not available.
     * This method is used to search a book based on the book Author name 
     * The name of the Author to be searched is passed as the parameter 
     * if the book is available the details of the book are displayed 
     * Book name : 
     * Author Name :
     * ISBN number :
     * Publisher :
     * The above details are displayed to the user. 
     * If the book is not available then a message is displayed to the user "Book is not available "
     * This method throws FileNotFoundException if the file containing the data of books is not available
     * FileName : booklist.csv
     */
    public  void searchByAuthor(String author) throws FileNotFoundException {
        
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                if(details[1].equalsIgnoreCase(author)){
                    String bookdetails ="\n"+"Book name :"+details[0]+"\n"+"Author name :"+details[1]+"\n"+"ISBN number :"+details[2]+"\n"+"Publisher :"+details[3];
                    searchResult =1;
                    System.out.println(bookdetails);
                    
                }
            }
            else{
                break;
            }
           

        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();
        

    }
    /**
     * This method is used to search the book by using the isbn  given by user.
     * @param isbn the ISBN number of the book to be searched is passed as parameter
     * @throws FileNotFoundException if the file booklist.csv is not available.
     * This method is used to search a book based on the book ISBN number 
     * The ISBN number of the book to be searched is passed as the parameter 
     * if the book is available the details of the book are displayed 
     * Book name : 
     * Author Name :
     * ISBN number :
     * Publisher :
     * The above details are displayed to the user. 
     * If the book is not available then a message is displayed to the user "Book is not available "
     * This method throws FileNotFoundException if the file containing the data of books is not available
     * FileName : booklist.csv
     */
    public  void searchByISBN(String isbn) throws FileNotFoundException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                if(details[2].equalsIgnoreCase(isbn)){
                    String bookdetails ="\n"+"Book name :"+details[0]+"\n"+"Author name :"+details[1]+"\n"+"ISBN number :"+details[2]+"\n"+"Publisher :"+details[3];
                    searchResult =1;
                    System.out.println(bookdetails);
                    
                }
            }
        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();
    }
    /**
     * This method is used to search the book by using the publisher name given by user.
     * @param publisher the name of the publisher is passed as parameter
     * @throws FileNotFoundException if the file booklist.csv is not available.
     * This method is used to search a book based on the Publisher Name 
     * The Publisher name  to be searched is passed as the parameter 
     * if the book is available the details of the book are displayed 
     * Book name : 
     * Author Name :
     * ISBN number :
     * Publisher :
     * The above details are displayed to the user. 
     * If the book is not available then a message is displayed to the user "Book is not available "
     * This method throws FileNotFoundException if the file containing the data of books is not available
     * FileName : booklist.csv
     */
    public void searchByPublisher(String publisher) throws FileNotFoundException {
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                if(details[3].equalsIgnoreCase(publisher)){
                    String bookdetails ="\n"+"Book name :"+details[0]+"\n"+"Author name :"+details[1]+"\n"+"ISBN number :"+details[2]+"\n"+"Publisher :"+details[3];
                    searchResult =1;
                    System.out.println(bookdetails);
                    
                }
            }
            

        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();

    }
    /**
     * This method is used to reserve the book by using the book name  and isbn given by user.
     * @param bookname the name of the book which the user wants to reserve is passed as parameter
     * @throws Exception if the file booklist.csv is not available or if the file is not Writable. 
     */
    public  void reserveBook(String bookname) throws Exception{
        BookDatabase bobj = new BookDatabase();
        bobj.searchByTitle(bookname);
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter the ISBN number of the book to be reserved :");
        String isbnNumber = scan1.nextLine();
        AccountMaintenance accobj = new AccountMaintenance(LibraryCaseStudy.mail);
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                int count = Integer.parseInt(details[4].trim());
                if(details[2].equalsIgnoreCase(isbnNumber) && count > 0){
                    searchResult =1;
                    break;
                }
            }
        }
        scan.close();
        if(searchResult ==1){
            Scanner sc=new Scanner(new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv"));
            String w="";
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                String temp=sc.next().trim();
                if(!temp.equals("")){
                    String array[]=temp.split(",");
                    if(array[2].equalsIgnoreCase(isbnNumber)){
                        int count=Integer.parseInt(array[4].trim());
                        count=count-1;
                        w=w+array[0]+","+array[1]+","+array[2]+","+array[3]+","+count+"\n";
                        accobj.updateIssuedBooks(bookname);
                        System.out.println("book reserved successfully");
                        
                    }
                    else{
                        w=w+temp+"\n";
                    }
                }
                
            }
            FileOutputStream f=new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
            byte b[]=w.getBytes();
            f.write(b);
            f.close();
        }
        else{
            System.out.println("book is not available currently");
        }
    }
    /**
     * This method is used to return the book by using the name given by user.
     * @param book the name of the book which the user wants to return.
     * @throws Exception
     * This method is used to return a book by the user 
     * The user can return the book only if it is issued to him/her
     * If the book is issued to the user then the bookname is stored in BookTransactionData.csv file 
     * by invoking updateReturnedBooks method and a message "Book returned Successfully" is displayed
     * If the book is not issued to the user then "Book has not been issued to you " message is displayed
     */
    public  void returnABook(String book) throws Exception {
        AccountMaintenance accobj = new AccountMaintenance(LibraryCaseStudy.mail);
        int result = accobj.isIssued(book);
        if(result ==1){
            System.out.println("Enter isbn number of the book issued :");
            Scanner scan1 = new Scanner(System.in);
            String isbn = scan1.nextLine();
            Scanner sc=new Scanner(new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv"));
            String w="";
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                String temp=sc.next().trim();
                if(!temp.equals("")){
                    String array[]=temp.split(",");
                    if(array[0].equalsIgnoreCase(book) && array[2].equals(isbn)){
                        int count=Integer.parseInt(array[4].trim());
                        count=count+1;
                        w=w+array[0]+","+array[1]+","+array[2]+","+array[3]+","+count+"\n";
                        System.out.println("book returned successfully");
                        accobj.updateReturnedBooks(book);
                        
                    }
                    else{
                        w=w+temp+"\n";
                    }
                }
            }
            FileOutputStream f=new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\booklist.csv");
            byte b[]=w.getBytes();
            f.write(b);
            f.close();
        }
        else{
            System.out.println("Book has not been issued to you");
        }
    }  
}