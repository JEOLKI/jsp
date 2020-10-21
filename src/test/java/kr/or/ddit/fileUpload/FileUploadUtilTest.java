package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {
	
	@Test
	public void getFilenameTest() {
		
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"brown.png\"";
		
		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);
		
	}

}
