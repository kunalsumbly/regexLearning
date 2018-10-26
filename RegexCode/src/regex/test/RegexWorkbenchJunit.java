package regex.test;

import org.junit.Assert;
import org.junit.Test;

public class RegexWorkbenchJunit {
	private RegexWorkbench targetObj = new RegexWorkbench();

	@Test
	public void teststringWithEscapeCharacter() {
		String[] s1 = { "sales1.xls", "orders3.xls", "sales2.xls", "sales3.xls", "apac1.xls", "europe2.xls", "na\\.xls",
				"na2.xls", "sa1.xls", "sa1.doc", "sales.xls","ca1.xls" };
		Assert.assertEquals(1,targetObj.stringWithEscapeCharacter(s1)); // this pattern should only match na\\.xls string
	}
	
	@Test
	public void teststringWithSpecificCharacterSet() {
		String[] s1 = { "sales1.xls", "orders3.xls", "sales2.xls", "sales3.xls", "apac1.xls", "europe2.xls", "na\\.xls",
				"na2.xls", "sa1.xls", "sa1.doc", "sales.xls","ca1.xls" };
		Assert.assertEquals(3,targetObj.stringWithSpecificCharacterSet(s1)); // this pattern should only match na\.xls , na2.xls, sa1.xls
	}

}
