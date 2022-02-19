package com.spring01.ex.controller.admin;

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
	
	// 첨부파일 저장할 디렉토리
	@Resource(name="upload_path")  // servlet-context.xml 파일에 beans bean id = "upload_path" 랑 같아야함. 
	String upload_path;
	
	@RequestMapping("/upload/input")
	public String input() {
		return "upload/input";
	}
	// MultipartFile file에 input.jsp 에 있는 form 태그안에서 확인 버튼 누른 첨부파일들이 쌓임  <inpu type = "file" name = "file"> 에 name 명 맞춰야함 
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception{ // file 처리는 throws Exception 넣어야함. 
		String savedName = file.getOriginalFilename();  // 첨부파일 이름 
		savedName = uploadFile(savedName, file.getBytes());  // uploadFile은 바로 아래 함수임. 
		mav.setViewName("upload/upload_result"); // 출력페이지 
		mav.addObject("saved_name", savedName);  // 출력페이지로 보낼 객체 
		return mav; 
	}
	
	// UUID : 업로드된 파일명의 중복 방지 위해 파일명을 변경할 때 사용, 첨부파일 다운로드시 다른 파일을 예측하여 다운로드하는 것을 방지, 일련번호 대신 유추하기 힘든
	// 식별자를 사용하여 다른 컨텐츠의 임의 접근을 방지하는데 사용
	// randomUUID() 메소드를 사용하여 유일한 식별자를 생성함. 반환되는 객체가 UUID 객체이므로 문자열 표현을 얻기 위해 toString() 메소드를 출력함. 
	public String uploadFile(String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();  // UUID는 파일이름이 중복되지 않도록 랜덤으로 id를 생성함  
		String savedName = uid.toString() + "_" + originalName; // uid.toString()은 fileName에 랜덤으로 만들어진 코드값을 넣음. 
		File target = new File(upload_path, savedName);  // 랜덤 붙이고 파일 생성함  => 파일 참조변수 File target 
		FileCopyUtils.copy(fileData, target);  // 파일 복사 
		// 파일 첨부를 하면 서버의 임시 저장소에 저장이됨. 그 것을 원하는 디렉토리로 복사함. => FileCopyUtils.copy(fileData, target) 
		return savedName;   // UUID가 포함된 파일이름을 리턴함. 
	}
	
}
