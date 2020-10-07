package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplitTest {

	private static final Logger logger = LoggerFactory.getLogger(CookieSplitTest.class);
	
	@Test
	public void test() {
		
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();

		/***When***/
		String cookieValue = cookieSplit.getCookieValue("USERNM");
		logger.debug(cookieValue);
		
		/***Then***/
		assertEquals("brown", cookieValue);
		
	}

}
