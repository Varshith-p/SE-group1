import java.io.File;
import java.util.Scanner;

public class Search {
    /**
     * This method takes the title of the book as the parameter to search whether the book is available or not  
     * @param title title of the book to be checked
     * @throws Exception
     * filename: booklist.csv
     */

    public static void searchByTitle(String title) throws Exception{
        File file = new File("booklist.csv");
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
                    searchResult =1;
                    break;
                }
            }
        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();

    }
    /**
     * This method takes the author of the book as parameter to search whether the book is available or not
     * @param author author of the book to be checked
     * @throws Exception
     * filename: booklist.csv
     */
    public static void searchByAuthor(String author) throws Exception{
        File file = new File("booklist.csv");
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
                    break;
                }
            }
           

        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();
        

    }
    /**
     * This method takes the isbn number of the book as parameter to search whether the book is available or not
     * @param isbn isbn number of the book to be checked
     * @throws Exception
     * filename: booklist.csv
     */

    public static void searchByISBN(String isbn) throws Exception{
        File file = new File("booklist.csv");
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
                    break;
                }
            }
        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();
    }
    /**
     * This method takes the author of the book as parameter to search whether the book is available or not
     * @param publisher publisher of the book to be checked
     * @throws Exception
     * filename: booklist.csv
     */

    public static void searchByPublisher(String publisher) throws Exception{
        File file = new File("booklist.csv");
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
                    break;
                }
            }
            

        }
        if(searchResult == 0){
            System.out.println("Book is not available");
        }
        scan.close();

    }
}




public  void reserveBook(String bookname) throws Exception {
        File file = new File("Booklist.csv");
        Scanner scan = new Scanner(file);
        int searchResult = 0;
        scan.useDelimiter("\n");
        while(scan.hasNext()){
            String temp = scan.next();
            if(!temp.equals("")){
                String[] details = temp.split(",");
                int count = Integer.parseInt(details[4]);//.trim());
                if(details[0].equalsIgnoreCase(bookname) && count > 0){
                    searchResult =1;
                    break;
                }
            } 
        }
        scan.close();
        if(searchResult ==1){
            Scanner sc=new Scanner(new File("Booklist.csv"));
            String w="";
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                String temp=sc.next().trim();
                if(!temp.equals("")){
                    String array[]=temp.split(",");
                    if(array[0].equalsIgnoreCase(bookname)){
                        int count=Integer.parseInt(array[4].trim());
                        count=count-1;
                        w=w+array[0]+","+array[1]+","+array[2]+","+array[3]+","+count+"\n";
                        //BookDatabase.updateIssuedBooks(bookname,LibraryCaseStudy.mail);
                        System.out.println("book reserved successfully");
                    }
                    else{
                        w=w+temp+"\n";
                    }
                }
                
            }
            FileOutputStream f=new FileOutputStream("booklist.csv");
            byte b[]=w.getBytes();
            f.write(b);
            f.close();
        }
        else{
            System.out.println("Book is not available currently");
        }
    }

