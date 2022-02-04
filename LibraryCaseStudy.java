import java.io.Console;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * LibraryCase Study
 * @author : SEGROUP-1
 * @version : 
 * This class comntains the method run which controls the flow of exceution depending on the user choice.
 * Methods are : run , search. 
 */
public class LibraryCaseStudy{

    static String mail;
    static int flag;
    private static String adminEmail="admin1@vvit.net";
    private static String adminPassword="12345";
    /**
     * This is the method that is called by the Main Method.
     * The process of displaying screens and calling the relavent methods is done in this method.
     * @throws Exception if the files are not available.
     */
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
            int choice = Integer.parseInt(scan.nextLine());
            System.out.println("\033[H\033[2J");
            System.out.flush();
            switch(choice){
                case 1:
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("1. Admin Login");
                    System.out.println("2. User login");
                    String email;
                    String password;
                    char[] passwordChars;
                    int choice1 = Integer.parseInt(scan.nextLine());
                    switch (choice1) {
                        case 1:
                            //Admin Login
                            System.out.println("Enter registered email:");
                            email = scan.nextLine();
                            while(!(valObj.validateEmail(email))){
                                System.out.println("Enter a valid email:");
                                System.out.println("Enter emailID:");
                                email=scan.nextLine();
                            }
                            System.out.println("Entered password is not visible on the screen");
                            System.out.println("Enter Password:");
                            passwordChars = cns.readPassword();
                            password = new String(passwordChars);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                            int result = -1;
                            if(email.equals(LibraryCaseStudy.adminEmail)&& password.equals(LibraryCaseStudy.adminPassword)){
                                result = 1;
                            }
                            else if(email.equals(LibraryCaseStudy.adminEmail)){
                                result = 0;
                            }
                            if(result == 1){
                                flag = 1;
                                System.out.println("Login SuccessFull");
                                LibraryCaseStudy.mail = email;
                                menuObj.displayAdminMenu();
                               
                            }
                            else if(result== -1){
                                System.out.println("You are not admin");
                                LibraryCaseStudy.run();
                            }
                            else{
                                System.out.print("entered incorrect password");
                                LibraryCaseStudy.run();
                            }
                        break;
            
                        case 2:
                            //user login 
                            System.out.println("Enter registered email:");
                            email = scan.nextLine();
                            while(!(valObj.validateEmail(email))){
                                System.out.println("Enter a valid email(use college mail id)");
                                System.out.println("Enter emailID:");
                                email=scan.nextLine();
                            }
                            System.out.println("Entered password is not visible on the screen");
                            System.out.println("Enter Password:");
                        passwordChars = cns.readPassword();
                            password = new String(passwordChars);
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                            result= dataObj.userLogin(email,password);
                            if(result== 1){
                                System.out.println("Login SuccessFull");
                                AccountMaintenance accobj = new AccountMaintenance(email);
                                accobj.updateLoginActivity();
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
                        default : LibraryCaseStudy.run();
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
                            FileOutputStream fo = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\BookTransactionData.csv",true);
                            String text =  "\n"+LibraryCaseStudy.mail;
                            byte[] array = text.getBytes();
                            fo.write(array);
                            fo.close();
                            FileOutputStream fo1 = new FileOutputStream("C:\\JAVAPROGRAMS\\SeAdminCode\\Files\\LoginActivity.csv",true);
                            String text1 =  "\n"+LibraryCaseStudy.mail+",";
                            byte[] array1 = text.getBytes();
                            fo1.write(array1);
                            fo1.close();

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
    /**
     * This method is used to take details of the book from the user and call the respective method .
     * Input details are taken based on the choice selected in Search Menu Screen.
     * @throws Exception if the file BookList is not available.
     */
    public static void search()throws Exception{
        BookDatabase bookObj = new BookDatabase();
        Menus menuObj = new Menus();
        menuObj.displaySearchMenu();
        System.out.println("enter your choice");
        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine());
        switch (choice) {
            case 1:
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.print("Enter book title :");
                String title = scan.nextLine();
                bookObj.searchByTitle(title);
                if(LibraryCaseStudy.flag == 1){
                    menuObj.displayAdminMenu();
                }
                menuObj.mainMenu();
                break;
            case 2:
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter book ISBN number  :");
                String ISBN = scan.nextLine();
                bookObj.searchByISBN(ISBN);
                if(LibraryCaseStudy.flag == 1){
                    menuObj.displayAdminMenu();
                }
                menuObj.mainMenu();
                break;
            case 3:
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter book Author name :");
                String author = scan.nextLine();
                bookObj.searchByAuthor(author);
                if(LibraryCaseStudy.flag == 1){
                    menuObj.displayAdminMenu();
                }
                menuObj.mainMenu();
                break;
            case 4:
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter book publisher name  :");
                String publisher = scan.nextLine();
                bookObj.searchByPublisher(publisher);
                if(LibraryCaseStudy.flag == 1){
                    menuObj.displayAdminMenu();
                }
                menuObj.mainMenu();
                break;
        
            case 5: 
                System.out.println("Returning to MainMenu");
                if(LibraryCaseStudy.flag == 1){
                    menuObj.displayAdminMenu();
                }
                menuObj.mainMenu();
                break;
        }
        scan.close();
    }
    
}