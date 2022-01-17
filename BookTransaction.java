import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * @author : V. Gnana chandra
 * @version : 1.0
 * 
 */
public class BookTransaction{
    private String email;
    public BookTransaction(String emailID)
    {
        this.email = emailID;

    }
    /**
     * This method should be placed in File named : AccountMaintenance.java
     * @param bookname the bookname to be added to the books issued to the user 
     * @param email the email of the user 
     * @throws IOException if it is not possible to write into file (BookTransactionData.csv) 
     * This method updates the BookTransactionData file . The name of the book issued to 
     * user is passed as parameter.  The book issued to the user is stored corresponding to the 
     * mail of the user along with the Date of issue.
     */
    public  void updateIssuedBooks(String bookname) throws IOException{
        LocalDate dobj = LocalDate.now();
        FileInputStream file = new FileInputStream("BookTransactionData.csv");
        try (Scanner scan = new Scanner(file)) {
            scan.useDelimiter("\n");
            String temp ="";
            while(scan.hasNext()){
                String text = scan.next();
                if(!text.equals("")){
                    String[] data = text.split(",");
                    if(data[0].equals(this.email) && data.length == 1){
                        temp = temp +data[0]+bookname+"  "+dobj+";";
                    }
                    else if(data[0].equals(this.email) && data.length == 3){
                        temp = temp +data[0]+","+data[1]+bookname+"  "+dobj+";" +","+data[2]+"\n";
                    }
                    else if(data[0].equals(this.email) && data.length == 2){
                        temp = temp +data[0]+","+data[1]+bookname+"  "+dobj+";"+"\n";
                    }
                    
                    else if(!data[0].equals(email)){
                        temp = temp + text;
                    }

                }
            }
            FileOutputStream fos = new FileOutputStream("BookTransactionData.csv");
            byte[] array = temp.getBytes();
            fos.write(array);
            fos.close();
        }
    }
    public static void main(String[] args) throws IOException {
       
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter book name :");
        String bookname = scan.nextLine();
        System.out.println("Enter email");
        String email = scan.nextLine();
        BookTransaction obj = new BookTransaction(email);
        obj.updateIssuedBooks(bookname);
        System.out.println("Book Transaction Noted");

    }
}