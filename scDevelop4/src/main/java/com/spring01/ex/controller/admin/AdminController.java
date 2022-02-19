package com.spring01.ex.controller.admin;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring01.ex.model.admin.AdminDAO;
import com.spring01.ex.model.member.MemberDTO;

@Controller
@RequestMapping("/admin/*") // 공통적인 url 매핑 http://localhost/spring04/admin/login.do
public class AdminController {
	
	@Inject
	AdminDAO adminDao;
	
	@RequestMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("login_check")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto, HttpSession session, ModelAndView mav) {
		String name = adminDao.login(dto); // login.jsp 에서 로그인을 한상태라서 dto에 정보가 담겨져있겠지 없으면 null이고 그러니깐 로그인하면 name은 null은 아님 
		if(name != null) {
			// 세션 변수 생성 
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			session.setAttribute("userid", dto.getUserid()); 
			session.setAttribute("name", name);
			mav.setViewName("admin/admin");
			mav.addObject("message", "success");
		} else {
			mav.setViewName("admin/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}
	
	
}
