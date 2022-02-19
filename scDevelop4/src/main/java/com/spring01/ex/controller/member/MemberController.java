package com.spring01.ex.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring01.ex.model.member.MemberDAO;
import com.spring01.ex.model.member.MemberDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Inject
	MemberDAO memberDao;
	
	@RequestMapping("address")
	public String address() {
		return "member/join";
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check")
	public ModelAndView login_check(MemberDTO dto, HttpSession session) {
		String name = memberDao.login(dto);
		if(name != null) {
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		ModelAndView mav = new ModelAndView();
		if(name != null) {
			mav.setViewName("main");
		} else {
			mav.setViewName("message/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		session.invalidate();
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}
}
