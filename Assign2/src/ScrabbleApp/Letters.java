package ScrabbleApp;

import java.util.ArrayList;
import java.util.List;
/**
 * Class to handle the letters representing scrabble tiles
 */
public class Letters {
	private String input;
	
	
	/**
	 * Creates a string using all inputed letters
	 * @param input String of letters input by user
	 */
	public Letters(String input) {
		this.input = new String(input);
	}
	
	
	/**
	 * Checks if string is 7 letters long or less
	 * @return Boolean value on weather the strings length is 7 or less
	 */
	public Boolean underSev() {
		return input.length() <= 7;
	}
	
	
	/**
	 * Checks if string only contains alphabetic letters
	 * @return Boolean value on weather the string contains only alphabetic letters
	 */
	public Boolean isAlp() {
		for(int i = 0; i < input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates an ArrayList, then calls permutations function to find all permutations of the string
	 * @return List of permutations of users inputed string
	 */
    public List<String> getArr() {
        List<String> arrList = new ArrayList<>();
        permutations("", input, arrList);
        return arrList;
    }
	
    /**
     * Constructs all permutations of inputed string
     * @param left Left portion of the individual permutation as its constructed
     * @param right Right portion, the remaining letters, of an individual permutation as its constructed
     * @param arrList List containing all arrangements / permutations
     */
    private void permutations(String left, String right, List<String> arrList) {
        int n = right.length();
        if (n == 0) {
            // Check for duplicates before adding
            if (!arrList.contains(left)) {
                arrList.add(left);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permutations(left + right.charAt(i),
                        right.substring(0, i) + right.substring(i + 1, n),
                        arrList);
            }
        }
    }
	
	
}
