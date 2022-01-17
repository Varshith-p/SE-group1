import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : V.Gnana Chandra 
 * @version : 1.0
 */
public class Issued {
    /**
     * This method should be placed in File named : AccountMaintenance.java
     * @param bookName the name of the book to be checked whehter the book is issued to the user or not
     * @param email the email of the user 
     * @return integer value  : 1 if the book is issued to the user
     * integer value : 0 if the book is not issued to the user
     * @throws FileNotFoundException if the file (BookTransactionData.csv) is not available
     * This method is used to check whether the book the user is trying to return is issed or not.
     * It checks the books issued to the user and returns a respective value based on whether the book has been issued or not
     */
    public int isIssued(String bookName, String email) throws FileNotFoundException{
       
        File file = new File("BookTransactionData.csv");
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
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter book name :");
        String bookname = scan.nextLine();
        System.out.println("Enter email:");
        String email = scan.nextLine();
        Issued obj = new Issued();
        int result = obj.isIssued(bookname, email);
        if(result == 1)
        {
            System.out.println("Book has been Issued");
        }
        else {
            System.out.println("Book is not Issued");
        }
    }
}
