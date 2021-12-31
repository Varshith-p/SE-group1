import java.util.Scanner;
public class Library {
    public void run() throws Exception {
        System.out.println("Enter a choice:");
        System.out.println("1.login\n2.Register");
        try (Scanner scan = new Scanner(System.in)) {
            int choice = Integer.parseInt(scan.nextLine());
            switch(choice){
                case 1: 
                    String email;
                    String password;
                    System.out.println("Enter registered email:");
                    email = scan.nextLine();
                    
                    while(!(Validation.validateEmail(email))){
                        System.out.println("Enter a valid email(use college mail id)");
                        System.out.println("Enter emailID:");
                        email=scan.nextLine();
                    }
                    
                    System.out.println("Enter Password:");
                    password = scan.nextLine();
                    int res = Login.authenticate(email, password);
                    if(res == 1){
                        System.out.println("Login SuccessFull");
                    }
                    else if(res == 0){
                        System.out.println("user is not registered.");
                    }
                    else{
                        System.out.print("incorrect password");
                    }
                    break;
                    
                case 2:
                    
                    System.out.println("Enter username:");
                    String name = scan.nextLine();
                    while(!(Validation.validateUserName(name))){
                        System.out.println("Enter a valid username:");
                        name = scan.nextLine();
                    }

                    System.out.println("Enter EmailID:");
                    String emailid = scan.nextLine();
                    while(!(Validation.validateEmail(emailid))){
                        System.out.println("Enter a valid Email:");
                        emailid = scan.nextLine();
                    }
                    
                    System.out.println("Enter year of study:");
                    int year = Integer.parseInt(scan.nextLine());
                    while(!Validation.validateYear(year)){
                        System.out.println("enter a valid year-(1-4):");
                        year = Integer.parseInt(scan.nextLine());
                    }
                    
                    System.out.println("Enter Branch:");
                    String branch = scan.nextLine();
                    while(!(Validation.branchValidation(branch))){
                        System.out.println("Enter a valid branch");
                         branch = scan.nextLine();
                    }
                    
                    System.out.println("Enter rollNumber:");
                    String rollNumber = scan.nextLine();
                    
                    System.out.println("Create a password:");
                    String rpassword = scan.nextLine();
                    if(!(Register.isRegistered(emailid))){
                        Register.registerUser(name, rollNumber, branch, emailid, year,rpassword);
                        System.out.println("user registeration completed");
                    }
                    else{
                        System.out.println("user already registerd");
                    }
                    break;
                    
                default :
                System.out.println("Enter a valid choice");
            }
        }
        
    }
}