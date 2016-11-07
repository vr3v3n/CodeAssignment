package in.varunrana.codeassignment.Utils;

/**
 * The purpose of this Class is to provide all the Utility feature through out
 * application. Currently,there are only 2 methods available which can easily be
 * implemented in the same class accessing them.
 *
 * But the class shows you the best way to implement common methods inside a Utils class.
 *
 * Created by vr3v3n on 07/11/16.
 */
public class Utils {

    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }


    /**
     * This function will return true if the provided string follow the following rule:
     * 1. String should not contain "@"
     *
     * @param userName
     * @return
     */
    public boolean isUserNameValid(String userName) {

        if(userName.contains("@"))
            return false;

        return true;
    }



    /**
     * This function will return true if the provided string follow the following rule:
     * 1. String length should be at least 6 characters long.
     *
     * @param paramString
     * @return
     */
    public boolean isStringLengthValid(String paramString) {
        return paramString.length() > UtilConstant.CONST_STR_LENGTH;
    }
}
