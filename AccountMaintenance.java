
import java.io.*;
import java.util.*;
import java.time.LocalDate;
/**
 * @author : SEGROUP-1-V.Gnana chandra
 * @version : 
 */

public class AccountMaintenance {
    private String email;

    public AccountMaintenance(String email){
        this.email = email;
    }

    /**
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
    /**
     * 
     * @param bookname the name of the book reserved by the user is passed as parameter
     * @throws IOException If the file which has the book transaction details is not available or not able to write to the file
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
            FileOutputStream fos = new FileOutputStream("BookTransactionData.csv");
            byte[] array = temp.getBytes();
            fos.write(array);
            fos.close();
        }
    }
   


    /**
     * 
     * @param bookname the name of the book returned by the user is passed as parameter
     * @throws IOException
     * This method updates the BookTransactionData file . The name of the book returned by the
     * user is passed as parameter.  The book returned by  the user is stored corresponding to the 
     * mail of the user along with the Date of return.
     */
    public  void updateReturnedBooks(String bookname) throws IOException{
        LocalDate dobj = LocalDate.now();
        FileInputStream file = new FileInputStream("BookTransactionData.csv");
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
            FileOutputStream fos = new FileOutputStream("BookTransactionData.csv");
            byte[] array = temp.getBytes();
            fos.write(array);
            fos.close();
        }
    }

}