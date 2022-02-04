import java.io.*;
import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/** Account Maintenance
 * @author : SEGROUP-1
 * @version : 1.0
 * This class contains the data and methods related to updating the books issued and returned by the user.
 * This class contains methods : isIssued, updateIssuedBooks , updateRetunredBooks 
 * These methods are used to update the file BookTransactionData which contains the data of books issued and returned by the user.
 * books issued and retunred are stored along with date of issue and date of return.
 */

public class AccountMaintenance {
    private String email;
   /**
     * This is a constructor used to set value to the instance variable email.
     * @param email the email of the user
     */
    public AccountMaintenance(String email){
        this.email = email;
    }
    
    /**
     * This method is used to check whether the book has been issued to the user or not
     * @param bookName name of the book is passed to check whether the book has been issued to the user or not
     * This method takes the bookname to be searched as parameter. 
     * @return integer value 1 if the book is issued else 0.
     * This method returns an integer value 1 if the book is issued to the user 
     * returns 0 if the book is not issued to the user
     * @throws FileNotFoundException
     * This method throws FileNOtFoundException if the file is not available 
     * filename : BookTransactionData.csv
     *
     */
    public int isIssued(String bookName) throws FileNotFoundException{
       
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\n");
            while(scan.hasNext()){
                String text = scan.next();
                if(!text.equals("")){
                    String[] data = text.split(",");
                    if(data[0].equals(email)){
                        String[] booksIssued = data[1].split(";");
                        for(int i =0; i< booksIssued.length ; i++){
                            String[] books = booksIssued[i].split("  ");
                            if(bookName.equals(books[0])){
                                return 1;
                            }
                        }
                    }
                }
                
            }
        }
        return 0;
    }
    /**
     * this method is used to update the data of books given to the user
     * @param bookname the name of the book reserved by the user is passed as parameter
     * @throws IOException If the file which has the book transaction details is not available or not able to write to the file
     * This method updates the BookTransactionData file . The name of the book issued to 
     * user is passed as parameter.  The book issued to the user is stored corresponding to the 
     * mail of the user along with the Date of issue.
     */
    
    public  void updateIssuedBooks(String bookname) throws IOException{
        LocalDate dobj = LocalDate.now();
        FileInputStream file = new FileInputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\n");
            String temp ="";
            while(scan.hasNext()){
                String text = scan.next();
                if(!text.equals("")){
                    String[] data = text.split(",");
                    if(data[0].equals(this.email) && data.length == 1){
                        temp = temp +data[0]+","+bookname+"  "+dobj+";"+"\n";
                    }
                    else if(data[0].equals(this.email) && data.length == 3){
                        temp = temp +data[0]+","+data[1]+bookname+"  "+dobj+";" +","+data[2]+"\n";
                    }
                    else if(data[0].equals(this.email) && data.length == 2){
                        temp = temp +data[0]+","+data[1]+bookname+"  "+dobj+";"+"\n";
                    }
                    
                    else if(!data[0].equals(email)){
                        temp = temp + text+"\n";
                    }

                }
            }
            FileOutputStream fos = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
            byte[] array = temp.getBytes();
            fos.write(array);
            fos.close();
        }
    }
    /**
     * this method is used to update the data of books returned by  the user
     * @param bookname the name of the book returned by the user is passed as parameter
     * @throws IOException
     * This method updates the BookTransactionData file . The name of the book returned by the
     * user is passed as parameter.  The book returned by  the user is stored corresponding to the 
     * mail of the user along with the Date of return.
     */
    public  void updateReturnedBooks(String bookname) throws IOException{
        LocalDate dobj = LocalDate.now();
        FileInputStream file = new FileInputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\n");
            String temp ="";
            while(scan.hasNext()){
                String text = scan.next();
                if(!text.equals("")){
                    String[] data = text.split(",");
                    if(data[0].equals(this.email) && data.length == 2){
                        temp = temp +data[0]+","+data[1]+","+bookname+"  "+dobj+";"+"\n";
                    }
                    else if(data[0].equals(this.email) && data.length >= 3){
                        temp = temp +data[0]+","+data[1]+","+data[2]+bookname +"  "+dobj+ ";"+"\n";
                    }
                    else if(!data[0].equals(this.email)){
                        temp = temp + text+"\n";
                    }

                }
            }
            FileOutputStream fos = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
            byte[] array = temp.getBytes();
            fos.write(array);
            fos.close();
        }
    }
    /**
     * Displays the book transaction Data of the user
     * @throws Exception
     * This method displays the books issued to the User along with Date of Issue
     * It also displays the books returned by the user along with the Date of Return
     * This method throws FileNotFoundException if the file is not available
     * FileName : BookTransactionData.csv
     */

    public  void booksHistory() throws Exception{
         
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next().trim();
            String[] data = temp.split(",");
            if(data[0].equals(this.email) && data.length >=1){
                int issued = 0;
                int returned = 0;
                if(data.length>=2){
                    String[] booksIssued = data[1].split(";");
                    System.out.println("\nBooks issued are\n");
                    System.out.println("Book name  Issued Date");
                    for(String a :booksIssued){
                        System.out.println(a);
                        issued =1;
                    }
                }
                if(issued ==0){
                    System.out.println("No books Issued");
                }
                if(data.length ==3){
                    String[] booksReturned = data[2].split(";");
                    System.out.println("\nBooks returned are");
                    System.out.println("\nBook name  Returned Date");
                    for(String a :booksReturned){
                        System.out.println(a);
                        returned =1;
                    }
                }
                if(returned ==0){
                    System.out.println("No books returned");
                }
            }
           
        }
        scan.close();
    }
    /**
     * updates the login time and date of the user.
     * This method is used to store the login date and  time of the user in the File "LoginActivity.csv".
     * Date and time are stored in corresponding email line.
     * @throws IOException if the File is not writable.
     */
    public void updateLoginActivity() throws IOException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\LoginActivity.csv");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\n");
        LocalDateTime obj = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String dateAndTime = obj.format(format);
        System.out.println(obj);
        String temp="";
        String text = "";
        while(scan.hasNext()){
            String data = scan.next();
            if(!data.isEmpty()){
                String[] details = data.split(",");
                if(details[0].equals(email)){
                    temp = temp +data;
                    temp = temp + ","+dateAndTime;
                    text = text + temp+"\n";
                }
                else{
                    text = text + data+"\n";
                }
            }
        }
        FileOutputStream fout = new FileOutputStream(file);
        byte[] b = text.getBytes();
        fout.write(b);
    }
    /**
     * Updates the logout time and data of the user.
     * This method is used to store the logout  date and  time of the user in the File "LoginActivity.csv".
     * Date and time are stored in corresponding email line.
     * @throws IOException if the File is not writable.
     */
    public void updateLogoutActivity() throws IOException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\LoginActivity.csv");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\n");
        LocalDateTime obj = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String dateAndTime = obj.format(format);
        System.out.println(obj);
        String temp="";
        String text = "";
        while(scan.hasNext()){
            String data = scan.next();
            if(!data.isEmpty()){
                String[] details = data.split(",");
                if(details[0].equals(email)){
                    temp = temp +data;
                    temp = temp + ","+dateAndTime;
                    text = text + temp+"\n";

                }
                else{
                    text = text + data+"\n";
                }
            }
        }
        FileOutputStream fout = new FileOutputStream(file);
        byte[] b = text.getBytes();
        fout.write(b);
    }
    /**
     * This method is used to display the Login and Logout activity of the user.
     * Details till the last logout are displayed to the user.
     * @throws FileNotFoundException if the file LoginActivity.csv is not available.
     */
    public void displayLoginActivity() throws FileNotFoundException{
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\LoginActivity.csv");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String data = scan.next();
            if(!data.isEmpty()){
                String[] details = data.split(",");
                if(details[0].equals(email)){
                    for(int i =1;i<details.length-1;i++){
                        System.out.println("Login :"+details[i]);
                        i++;
                        if(i==details.length){
                            break;
                        }
                        System.out.println("Logout :"+details[i]);
                        System.out.println("-----------------------");
                    }
                }
            }
        }
    }
    /**
     * This method is used by the user to recommend his favourite books to the library
     * @throws IOException if the file RecommendedBooks.csv is not Writable.
     * 
     */
    public void recommendBook() throws IOException  {
        LocalDate dobj = LocalDate.now();
        File file = new File("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\RecommendedBooks.csv");
        FileWriter writer = new FileWriter(file,true);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of Book :");
        String bookName = scan.nextLine();
        System.out.println("Enter Author Name :");
        String authorName = scan.nextLine();
        System.out.println("Enter ISBN number :");
        String isbnNumber = scan.nextLine();
        System.out.println("Enter Publisher Name :");
        String publisherName  = scan.nextLine();

        String bookData = "\n"+email +bookName + "," + authorName +"," + isbnNumber + "," + publisherName +"," + dobj;
        writer.write(bookData);
        writer.close();
        
    }
}