package kr.or.ddit.fileUpload;

public class FileUploadUtil {
	
	// form-data; name="img"; filename="brown.png"
	// => sally.png
	
	// FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		
		String[] contents = contentDisposition.split("; ");
		
		for (int i = 0; i < contents.length; i++) {
			
			String[] content = contents[i].split("=");
			
			if(content[0].equals("filename")) return content[1].replace("\"", ""); // 더블 쿼테이션 제거

		}
		
		return "";
	}
	
}
