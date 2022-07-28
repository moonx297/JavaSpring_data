package com.myspring.pro28.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	//썸네일 폴더에 이미지 저장
	/*@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".gif");	//저장
	
		//이미지를 조정해준다. png -> gif 권장 (용량 차이 : 256 컬러밖에 없는 gif가 용량이 작다.)
		//작은 이미지는 화질 차이가 잘 느껴지지 않으므로, 썸네일 (작은 이미지) 는 gif가 좋다. 256 => 2^8승 8비트
		//썸네일 폴더를 만들어서 파일을 저장한다.
		if (image.exists()) { 
			thumbnail.getParentFile().mkdirs();	//폴더 자동 생성 함수 mkdirs()
		    Thumbnails.of(image).size(50,50).outputFormat("gif").toFile(thumbnail);	 //출력
		}

		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}*/
	
	//c:\\spring\\image_repo 안의 썸네일 폴더에 저장하지 않고 바로 올린다라는 뜻. -> 위 코드보다 좀 더 빠르게 등록된다.
	//위 코드 방법 선호
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".gif");
		if (image.exists()) { 
			Thumbnails.of(image).size(50,50).outputFormat("gif").toOutputStream(out);
		}else {
			return;
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	
}
