
import java.util.regex.Pattern;
/**
 * @author : SEGROUP-1
 * @version : 1.0
 * Validation
 *  This class contains the methods to validate the entered details. 
 * Email, username , branch, year of study are validated as per the given conditions
 */
public class Validation{
    /**
     * validates the given username .
     * @param name username
     * @return boolean true if the username is valid
     *         boolean false if the username is invalid
     */
    public  boolean validateUserName(String name){
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
     * validates year of study 
     * @param year year of study
     * @return boolean true if the year is valid (in between 1-4)
     *         boolean false if the year is not valid
     */
    public  boolean validateYear(int year) {

        if(year>= 1 && year <=4){
            return true;
        }
        return false;

    }
    /**
     * validates the email entered by the user
     * @param email email of the user
     * @return boolean true if the email is valid (follows proper syntax)
     *         boolean false if the email is not valid
     */
    public  boolean validateEmail(String email)
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
     * validates the branch entered by the user.
     * @param branch the branch in which the student is studying
     * @return boolean true if the branch is a valid branch
     *         boolean false if the branch is not valid
     */
    public  boolean branchValidation(String branch) {
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
