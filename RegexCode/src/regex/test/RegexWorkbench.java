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

}
