import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Login
{
    public static int authenticate(String email, String password) throws FileNotFoundException{
        int count =0;
        int index1=0;
        int index2=0;
        File file = new File("EmailsFile.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()){
                if(scan.nextLine().equals(email)){
                    count = 1;
                    break;
                }
                index1++;
            }
        }
        File file2 = new File("passwords.txt");
        try (Scanner scan2 = new Scanner(file2)) {
            while(scan2.hasNextLine()){
                if(scan2.nextLine().equals(password) && (index1 == index2)){
                    count =2;
                    break;
                }
                index2++;
            }
        }
        if(count == 2){
            return 1;
        }
        else if(count == 1){
            return -1;
        }
        return 0;
    }

}
