package PasswordStrengthApp;
/**
 * Class to handle user inputed password
 */
public class Password {
    private String pass;

    /**
     * Creates a password
     * @param input String containing user inputed password
     */
    public Password(String input) {
        this.pass = input;
    }

    /**
     * Makes sure password is no less than 8 characters and no more than 12 characters
     * @return Boolean value, True if password does not meet length requirements
     */
    public boolean isLength() {
        return pass.length() >= 8 && pass.length() <= 12;
    }

    /**
     * Determines if password has any spaces
     * @return Boolean value, true if the password contains spaces
     */
    public boolean hasSpaces() {
        return pass.contains(" ");
    }

    /**
     * Iterates through password and determines length of the greatest sequence of repeating characters
     * @return integer value representing length of greatest sequence of repeating characters
     */
    public int getBlock() {
        int max = 0;
        int cnt = 1;
        
        for (int i = 1; i < pass.length(); i++) {
            if (pass.charAt(i) == pass.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt > max) {
                    max = cnt;
                }
                cnt = 1;
            }
        }

        if (cnt > max) {
            max = cnt;
        }
        
        return max;
    }

}
