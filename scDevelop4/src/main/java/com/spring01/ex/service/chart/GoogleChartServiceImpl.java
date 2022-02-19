package com.spring01.ex.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.spring01.ex.model.shop.CartDAO;
import com.spring01.ex.model.shop.CartDTO;

@Service
public class GoogleChartServiceImpl implements GoogleChartService {
	
	@Inject
	CartDAO cartDao;
	
	@Override
	public JSONObject getChartData() {
		List<CartDTO> items = cartDao.cart_money(); // 품목별 금액 리스트 
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		col1.put("label", "상품명");
		col1.put("type", "String");
		col2.put("label", "금액");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2); 
		JSONArray body = new JSONArray();
		
		// 위에는 title 제목 컬럼
		// for문 아래에는 실제 데이터값 
		for(CartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProduct_name()); // 상품 이름 
			JSONObject money = new JSONObject();
			money.put("v", dto.getMoney());
			name.put("v", dto.getMoney());  // 상품 가격  (이름, 가격 다 디비에서 끌어오자) 
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell = new JSONObject();
			cell.put("c", row); // 끌어온거 바디에 추가해 
			body.add(cell);
		}
		data.put("rows", body);
		return data;
	}

}
