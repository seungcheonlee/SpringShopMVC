package com.spring01.ex.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring01.ex.service.chart.GoogleChartService;

@RestController // 데이터 리턴 (페이지 이동 아님) 그래서 페이지이동 할 때에는 ModelAndView 를 사용하자 
@RequestMapping("/chart/*")
public class GoogleChartController {
	@Inject
	GoogleChartService googleChartService;
	
	@RequestMapping("chart1")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01"); // view로 이동 
	}
	
	@RequestMapping("chart2")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}
	
	@RequestMapping("cart_money_list")
	public JSONObject cart_money_list() { // view가 아닌 실제 데이터를 리턴한다. @ResponseBody 와 동일함 
		return googleChartService.getChartData();
	}
}
