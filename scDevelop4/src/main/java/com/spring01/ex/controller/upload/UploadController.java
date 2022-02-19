package com.spring01.ex.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	// 첨부 파일 저장할 디렉토리 --> servlet-context.xml에 bean으로 의존 주입 설정해놓음. 
	// 이거와 동일  String upload_path = "c:/upload";
	@Resource(name = "upload_path")
	String upload_path;
	
	@RequestMapping("/upload/input")
	public String input() {
		return "upload/input";
	}
	
	@RequestMapping("/upload/upload")
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception{
		//첨부 파일 이름
		String savedName = file.getOriginalFilename();
		// uuid를 추가한 파일 이름
		savedName = uploadFile(savedName, file.getBytes());
		mav.setViewName("upload/upload_result");
		mav.addObject("saved_name", savedName);
		return mav;
	}
	
	public String uploadFile(String originalName, byte[] fileData) throws Exception{
		// UUID 생성  -- > Universal Unique Identifier 범용 고유 식별자
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(upload_path, savedName);
		// 파일 복사
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	
}
