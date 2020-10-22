package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);
	
	@Test
	public void getFilenameTest() {
		
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"brown.png\"";
		
		/***When***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);
		
	}

	@Test
	public void UUIDTest() {
		/***Given***/

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);
		
		/***Then***/
		
	}
	
	@Test
	public void getExtensionTest() {
		/***Given***/
		String filename = "sally.png";

		/***When***/
		String extension = FileUploadUtil.getExtension(filename);

		/***Then***/
		assertEquals("png", extension);
	}
	
	@Test
	public void getExtensionFailTest() {
		/***Given***/
		String filename = "sally";
		
		/***When***/
		String extension = FileUploadUtil.getExtension(filename);
		
		/***Then***/
		assertEquals("", extension);
	}
	
}
