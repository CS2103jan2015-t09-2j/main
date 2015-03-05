package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateParserTest {

	@Test
	public void test() {
		DateParser dp = new DateParser();
		assertEquals(dp.extractDate("April 3"), "27/03/2015");
	}

}
