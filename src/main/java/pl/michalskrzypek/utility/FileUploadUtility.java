package pl.michalskrzypek.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\Development\\eclipse\\workspace\\OnlineShop\\src\\main\\webapp\\assets\\images\\";
	
	public static void UploadFile(MultipartFile multipartFile, String code) {

		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		
		try {
			multipartFile.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
