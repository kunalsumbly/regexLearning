package regex.test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWorkbench {
	
	public int stringWithEscapeCharacter(String [] inputString) {
		/**
		 * \ is represented by \\ in java 
		 * so to actually match "\" in a string using regex we first need to escape the meta character "\" itself using "\\"
		 * so in java "\\" becomes "\\\\" --> brain fart
		 */
		try{
			Pattern pattern = Pattern.compile("\\\\"); 
			runPattern(pattern,inputString);
			return countNumberOfMatches(pattern, inputString);
		}catch (Exception e) {
			return 0;
		}
	}


	private void runPattern(Pattern pattern,String [] inputString) {
		for (String str : inputString) {
			System.out.println("String to be matched::::"+str);
			Matcher matcher = pattern.matcher(str);
			System.out.println("Found the match??"+matcher.find());
		}
	}
	
	private int countNumberOfMatches(Pattern pattern,String [] inputString) {
		int count=0;
		for (String str : inputString) {
			Matcher matcher = pattern.matcher(str);
			count=matcher.find()?++count:count;
		}
		return count;
	}
	
	public int stringWithSpecificCharacterSet(String [] inputString){
			try{
				Pattern pattern = Pattern.compile("[ns]a.\\.xls"); 
				runPattern(pattern,inputString);
				return countNumberOfMatches(pattern, inputString);
			}catch (Exception e) {
				return 0;
			}
	}
	
	public int stringWithNotCondition(String [] inputString){
		try{
			/**
			 * This pattern says 
			 * 1) can start with n or s
			 * 2) followed by 'a'
			 * 3) next character cannot be numeric/digit hence [^0-9]
			 * 4) escape (java escape means double backward slashes \\) . and consider as a plain text or char
			 *  
			 */
			Pattern pattern = Pattern.compile("[ns]a[^0-9]\\.xls"); 
			runPattern(pattern,inputString);
			return countNumberOfMatches(pattern, inputString);
		}catch (Exception e) {
			return 0;
		}
	}
	
	public int stringWithNotPatternSetAndArray(String [] inputString){
		try{
			
			Pattern pattern = Pattern.compile("myarray\\[[0-9][0-9]*\\]"); 
			runPattern(pattern,inputString);
			return countNumberOfMatches(pattern, inputString);
		}catch (Exception e) {
			return 0;
		}
	}
	
	// this pattern is to specify only digits from 0-9 and only if there are 4 or 6 in number
	public int stringWithDigits(String [] inputString){
		try{
			Pattern pattern = Pattern.compile("^[0-9]{4}$"); 
			runPattern(pattern,inputString);
			return countNumberOfMatches(pattern, inputString);
		}catch (Exception e) {
			return 0;
		}
		
	}

}
