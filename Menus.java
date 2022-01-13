import java.util.*;
public class Menus {
    
    public  void mainMenu() throws Exception {

        Menus menuObj = new Menus();
        System.out.println("\n------MAIN MENU------\n");
        System.out.println("1. Search a Book");
        System.out.println("2. Reserve  Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Help and feedback");
        System.out.println("5. recommend a book");
        System.out.println("6. Account Maintenance");
        System.out.println("7. LogOut");
        System.out.println("Enter your choice:");
        try (Scanner scan = new Scanner(System.in)) {
            int choice2 = Integer.parseInt(scan.nextLine());
            System.out.println("\033[H\033[2J");
            System.out.flush();
            switch(choice2){

                case 1 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;
                case 2 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;

                case 3 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;

                case 4 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;

                case 5 :

                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;
                case 6 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;

                case 7 :
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;
                default : 
                    System.out.println("code is in progress");
                    menuObj.mainMenu();
                    break;
            }
        }
    }
    public  void displaySearchMenu(){
        System.out.println("---------------------------Search menu---------------------------");
        System.out.println("1 - Search by title");
        System.out.println("2 - Search by ISBN number");
        System.out.println("3 - Search by author name");
        System.out.println("4 - Search by publisher");
        System.out.println("5 - Exit");
        
    }
}
