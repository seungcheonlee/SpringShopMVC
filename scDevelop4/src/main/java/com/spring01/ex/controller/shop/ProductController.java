package com.spring01.ex.controller.shop;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring01.ex.model.shop.ProductDAO;
import com.spring01.ex.model.shop.ProductDTO;

@Controller
@RequestMapping("/shop/product/*")
public class ProductController {
	@Inject
	ProductDAO productDao;
	
	
	@RequestMapping("write")
	public String write() {
		return "shop/product_write"; // 상품등록 페이지 
	}
	
	@RequestMapping("insert")
	public String insert(ProductDTO dto, HttpServletRequest request) {
		String filename = "-"; // 첨부파일 없으면 하이푼 표시 
		if(!dto.getFile1().isEmpty()) { // 첨부파일이 있으면 
			filename = dto.getFile1().getOriginalFilename(); // 파일이름 
			try {
				// application 객체 생성(서버 전체에서 공유) -> 배포 디렉토리 
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/WEB-INF/views/images/"); // 실제 서비스 경로 
				new File(path).mkdir(); // 디렉토리 생성 
				dto.getFile1().transferTo(new File(path + filename)); // 첨부파일이 지정된 디렉토리에 복사 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setFilename(filename); // 첨부파일이름 저장 
		productDao.insert(dto);  // 레코드 저장 
		return "redirect:/shop/product/list";
	}
	
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list");
		mav.addObject("list", productDao.list());
		return mav;
	}
	
	@RequestMapping("edit/{product_code}")
	public ModelAndView edit(@PathVariable("product_code") int product_code, ModelAndView mav) {
		mav.setViewName("/shop/product_edit");
		mav.addObject("dto", productDao.detail(product_code));
		return mav;
	}
	
	@RequestMapping("update")
	public String update(ProductDTO dto, HttpServletRequest request) {
		String filename = "-";
		if(!dto.getFile1().isEmpty()) {  // 첨부파일 있으면 
			filename = dto.getFile1().getOriginalFilename();
			try {
				// application 객체 생성 (서버 전체에서 공유) 
				ServletContext application = request.getSession().getServletContext(); // 배포 디렉토리 
				String path = application.getRealPath("/WEB-INF/views/images/"); // 실제 서비스 경로 
				new File(path).mkdir(); // 디렉토리 생성 
				dto.getFile1().transferTo(new File(path + filename)); // 임시저장소에 있던 것을 transferto를 통해 디렉토리 이동시킴 (첨부파일이 지정된 디렉토리에 복사)
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setFilename(filename);
		} else {  // 첨부파일 없으면 기존 정보 가져와서 셋팅 
			ProductDTO dto2 = productDao.detail(dto.getProduct_code()); // 기존 첨부파일 정보 가져와서 셋팅 
			dto.setFilename(dto2.getFilename());
		}
		productDao.update(dto); // 레코드 수정하고 다시 리스트로 
		return "redirect:/shop/product/list";
	}
	
	@RequestMapping("delete")
	public String delete(int product_code, HttpServletRequest request) {
		String filename = productDao.file_info(product_code);
		if(filename != null && !filename.equals("-")) {
			ServletContext application = request.getSession().getServletContext();
			String path = application.getRealPath("/WEB-INF/views/images/");
			File f = new File(path + filename);
			if(f.exists()) // 첨부파일이 존재하면 
				f.delete();  // 파일 삭제  
		}
		productDao.delete(product_code); // 레코드도 삭제 (위에서 f.delete 했으니 레코드도 삭제해야함. 
		return "redirect:/shop/product/list"; // 다시 list로 보내 
	}
	
	@RequestMapping("detail/{product_code}")
	public ModelAndView detail(@PathVariable int product_code, ModelAndView mav) {
		mav.setViewName("/shop/product_detail");
		mav.addObject("dto", productDao.detail(product_code));
		return mav;
	}
}
