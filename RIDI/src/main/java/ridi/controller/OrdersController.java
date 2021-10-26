package ridi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ridi.model.orders.OrdersDao;
import ridi.model.orders.OrdersDto;

@Controller
@Slf4j
public class OrdersController {

	@Autowired
	OrdersDto ordersDto;
	
	@Autowired
	OrdersDao ordersDao;
	
	//유저 카트 페이지로 이동한다.
	@RequestMapping("/CartListForm.do")
	public String eight() {
		return "orders/cartList";
	}
	
	// 카트에 실을 정보를 DB에 저장한다.
	@RequestMapping("/PutInShoppingCart.do")
	@ResponseBody
	public int putInShoppingCart(OrdersDto ordersDto) {
		int result = 0;
		result = ordersDao.insertOrder(ordersDto);
		
		return result;
	}
	
	@RequestMapping("/GetShoppingCartList.do")
	@ResponseBody
	public Map<String,Object> getShoppingCartList(@RequestParam Map<String,Object> map){
		String id = (String)map.get("id");
		log.info("id======================================================================{}",id);
		Map<String,Object> hashMap = new HashMap<String,Object>();
		List<OrdersDto> shoppingCartList = ordersDao.getAllCartList(id);
		hashMap.put("shoppingCartList", shoppingCartList);
		
		return hashMap;
	}
}
