
import java.util.regex.Pattern;

public class Validation{
    /**
     * 
     * @param name 
     * @return boolean true if the user name is valid 
     * returns false if the user name is invalid
     */
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
    /**
     * 
     * @param year
     * @return boolean true if year is in between 1 and 4(1,4 are inclusive) 
     * returns false if it is beyond range
     */
    public static boolean validateYear(int year) {

        if(year>= 1 && year <=4){
            return true;
        }
        return false;

    }
    /**
     * 
     * @param email
     * @return boolean true if the email is having a valid syntax
     * returns false if it is having invalid syntax
     */
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
    /**
     * 
     * @param branch
     * @return boolean true if the branch entered by the user is valid
     * returns false if it is invalid
     */
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
