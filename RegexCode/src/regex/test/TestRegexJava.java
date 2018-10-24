package regex.test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegexJava {
	public static void main(String[] args) {
		String[] s1 = { "sales1.xls", "orders3.xls", "sales2.xls", "sales3.xls", "apac1.xls", "europe2.xls", "na\\.xls",
				"na2.xls", "sa1.xls", "sa1.doc", "sales.xls" };

		/**
		 * \ is represented by \\ in java 
		 * so to actually match "\" in a string using regex we first need to escape the meta character "\" itself using "\\"
		 * so in java "\\" becomes "\\\\" --> brain fart
		 */
		Pattern pattern = Pattern.compile("\\\\"); // \\ in Java is \ so to actually match "\." 
		
		for (String str : s1) {
			System.out.println("String to be matched::::"+str);
			Matcher matcher = pattern.matcher(str);
			System.out.println("Found the match??"+matcher.find());
		}
		
	
	}

}
