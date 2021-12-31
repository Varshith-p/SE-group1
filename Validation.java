
import java.util.regex.Pattern;

public class Validation{
    public static boolean validateUserName(String name){
        name = name.toLowerCase();
        String[] nameArray = name.split(" ");
        String newName ="";
        for(int k=0; k< nameArray.length;k++){
            newName = newName + nameArray[k];
        }
        char[] charArray = newName.toCharArray();
        for(int i=0; i<charArray.length;i++){
            char ch = charArray[i];
            if(!(ch>='a' && ch<='z')){
                return false;
            }
        }
        return true;       
    }
    public static boolean validateYear(int year) {

        if(year>= 1 && year <=4){
            return true;
        }
        return false;

    }
    public static boolean validateEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean branchValidation(String branch) {
        int count =0;
        String[] branches = new String[] {"CSE","EEE","MECH","CIVIL","IT","ECE","CSM","CIC","CSO"};
        for(int i=0;i<branches.length;i++) {
            if(branches[i].equalsIgnoreCase(branch)) {
                count =1;
            }
        }
        if(count ==0){
            return false;
        }
        return true;
    }
}
