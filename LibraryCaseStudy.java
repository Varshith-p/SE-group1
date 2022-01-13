import java.io.Console;
import java.io.FileOutputStream;
import java.util.Scanner;

public class LibraryCaseStudy {

    static String mail;
    public static void run() throws Exception{
        Menus menuObj = new Menus();
        Validation valObj = new Validation();
        Database dataObj = new Database();
        Console cns = System.console();
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n---------MAIN SCREEN --------");
        System.out.println("\n\nWELCOME TO LIBSOFT ");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.EXIT");
        System.out.println("\nEnter Your choice  : ");
        try (Scanner scan = new Scanner(System.in)) {
            int choice1 = Integer.parseInt(scan.nextLine());
            System.out.println("\033[H\033[2J");
            System.out.flush();
            switch(choice1){
                case 1:
                        String email;
                        String password;
                        System.out.println("Enter registered email:");
                        email = scan.nextLine();
                        while(!(valObj.validateEmail(email))){
                            System.out.println("Enter a valid email(use college mail id)");
                            System.out.println("Enter emailID:");
                            email=scan.nextLine();
                        }
                        System.out.println("Entered password is not visible on the screen");
                        System.out.println("Enter Password:");
                        char[] passwordChars = cns.readPassword();
                        password = new String(passwordChars);
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        int result= dataObj.userLogin(email,password);
                        if(result== 1){
                            System.out.println("Login SuccessFull");
                            LibraryCaseStudy.mail = email;
                            menuObj.mainMenu();
                        }
                        else if(result== 0){
                            System.out.println("user is not registered.");
                            LibraryCaseStudy.run();
                        }
                        else{
                            System.out.print("incorrect password");
                            LibraryCaseStudy.run();
                        }
                        break;
                
                case 2 : 
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\n--------USER REGISTERATION--------\n");
                        System.out.println("Enter username:");
                        String name = scan.nextLine();
                        while(!(valObj.validateUserName(name))){
                            System.out.println("Enter a valid username:");
                            name = scan.nextLine();
                        }

                        System.out.println("Enter EmailID:");
                        String emailid = scan.nextLine();
                        while(!(valObj.validateEmail(emailid))){
                            System.out.println("Enter a valid Email:");
                            emailid = scan.nextLine();
                        }
                        
                        System.out.println("Enter year of study:");
                        int year = Integer.parseInt(scan.nextLine());
                        while(!valObj.validateYear(year)){
                            System.out.println("enter a valid year-(1-4):");
                            year = Integer.parseInt(scan.nextLine());
                        }
                        
                        System.out.println("Enter Branch:");
                        String branch = scan.nextLine();
                        while(!(valObj.branchValidation(branch))){
                            System.out.println("Enter a valid branch");
                            branch = scan.nextLine();
                        }
                        
                        System.out.println("Enter rollNumber:");
                        String rollNumber = scan.nextLine();
                        
                        System.out.println("Create a password:");
                        String rpassword = scan.nextLine();
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        if(!(dataObj.isRegistered(emailid))){
                            dataObj.registerUser(name, rollNumber, branch, emailid, year,rpassword);
                            LibraryCaseStudy.mail = emailid;
                            FileOutputStream fo = new FileOutputStream("BookTransactionData.csv",true);
                            String text =  "\n"+LibraryCaseStudy.mail;
                            byte[] array = text.getBytes();
                            fo.write(array);
                            fo.close();

                            System.out.println("user registeration completed");
                            LibraryCaseStudy.run();
                        }
                        else{
                            System.out.println("user already registerd");
                            LibraryCaseStudy.run();
                        }
                        break;
                case 3:
                        System.exit(0);

                default : System.out.println("enter a valid choice ");
                          LibraryCaseStudy.run();


            }
        }
    }
    public static void search() throws Exception{
        Menus menuObj = new Menus();
        menuObj.displaySearchMenu();
        System.out.println("enter your choice");
        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine());
        switch (choice) {
            case 1:
                System.out.print("Enter book title :");
                String title = scan.nextLine();
                BookDatabase.searchByTitle(title);
                menuObj.mainMenu();
                break;
            case 2:
                System.out.println("Enter book ISBN number  :");
                String ISBN = scan.nextLine();
                BookDatabase.searchByISBN(ISBN);
                menuObj.mainMenu();
                break;
            case 3:
                System.out.println("Enter book Author name :");
                String author = scan.nextLine();
                BookDatabase.searchByAuthor(author);
                menuObj.mainMenu();
                break;
            case 4:
                System.out.println("Enter book publisher name  :");
                String publisher = scan.nextLine();
                BookDatabase.searchByPublisher(publisher);
                menuObj.mainMenu();
                break;
        
            case 5: 
                System.out.println("Returning to MainMenu");
                menuObj.mainMenu();
                break;
        }
        scan.close();
    }
    
}