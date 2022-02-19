package com.spring01.ex.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring01.ex.model.shop.CartDAO;
import com.spring01.ex.model.shop.CartDTO;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	@Inject
	CartDAO cartDao;
	
	@RequestMapping("delete") // 장바구니 목록 데이터 개별삭제(장바구니에 상품이 여러개 있으면 하나하나 삭제) 
	public String delete(int cart_id) {
		cartDao.delete(cart_id);
		return "redirect:/shop/cart/list"; // 장바구니 목록으로 
	}
	
	@RequestMapping("deleteAll") // 장바구니 모두 비우기 
	public String deleteAll(HttpSession session) {
		String userid = (String)session.getAttribute("userid"); // 세션검사(세션도 없는데 삭제할 수도 있어서 세션 미리 검사) 
		if(userid!=null) {
			cartDao.delete_all(userid);
		}
		return "redirect:/shop/cart/list";
	}
	
	@RequestMapping("update") // 여러개 한번에 수정(배열 사용) 
	public String update(int[] amount, int[] cart_id, HttpSession session) {
		String userid = (String)session.getAttribute("userid"); // 세션검사 (세션이 널이면 로그인 페이지로) 
		if(userid == null) {
			return "redirect:/member/login";
		}
		for(int i = 0; i< cart_id.length; i++) {
			if(amount[i]==0) {  // 장바구니에 담긴 물건의 수량이 0 이면 삭제 
				cartDao.delete(cart_id[i]);
			} else {
				CartDTO dto = new CartDTO();  // 장바구니의 값을 셋팅하기위해 객체 생성 
				dto.setUserid(userid);
				dto.setCart_id(cart_id[i]);
				dto.setAmount(amount[i]);
				cartDao.modify(dto);
			}
		}
		return "redirect:/shop/cart/list";
	}
	
	@RequestMapping("list")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		Map<String, Object> map = new HashMap<>();
		String userid = (String)session.getAttribute("userid");
		if(userid != null) {
			List<CartDTO> list = cartDao.list(userid);
			int sumMoney = cartDao.sum_money(userid); // 전체 금액 합
			int fee = sumMoney>=30000?0:2500; // 배송료 계산 
			map.put("sumMoney", sumMoney);
			map.put("fee", fee);
			map.put("sum", sumMoney+fee);
			map.put("lisrt", list);
			map.put("count", list.size());
			mav.setViewName("shop/cart_list");  // 출력페이지로 이동 
			mav.addObject("map", map);
			return mav;
		} else {
			return new ModelAndView("member/login");
		}
	}
	// 장바구니 담기 
	@RequestMapping("insert")
	public String insert(CartDTO dto, HttpSession session) {
		String userid = (String)session.getAttribute("userid"); // 세션 적용 
		if(userid == null) {
			return "redirect:/member/login";
		}
		dto.setUserid(userid);
		cartDao.insert(dto);
		return "redirect:/shop/cart/list";
	}
}
