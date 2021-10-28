package ridi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDto;
import ridi.model.orders.OrdersDao;
import ridi.model.orders.OrdersDto;
import ridi.utlils.ScriptWriterUtil;

@Controller
@Slf4j
public class OrdersController {

	@Autowired
	OrdersDto ordersDto;
	
	@Autowired
	OrdersDao ordersDao;
	
	@Autowired
	MemberDto memberDto;
	
	//////////////////////////////// 카트/찜하기 관련 ////////////////////////////////
	//유저 카트 페이지로 이동한다.
	@RequestMapping("/CartListForm.do")
	public String cartListForm(HttpSession session, HttpServletResponse response) throws IOException {
		memberDto = (MemberDto)session.getAttribute("loggedMember");
		
		if(memberDto == null) {
			ScriptWriterUtil.alertAndBack(response, "로그인 후 이용해주세요");
		}
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
	
	// 유저별 카트리스트를 DB에서 가져온다
	@RequestMapping("/GetShoppingCartList.do")
	@ResponseBody
	public Map<String,Object> getShoppingCartList(@RequestParam Map<String,Object> map){
		String id = (String)map.get("id");
		Map<String,Object> hashMap = new HashMap<String,Object>();
		List<OrdersDto> shoppingCartList = ordersDao.getAllCartList(id);
		hashMap.put("shoppingCartList", shoppingCartList);
		
		return hashMap;
	}
	
	// 찜한 내용을 1개 삭제한다.
	@RequestMapping("/DeleteShoppingCart.do")
	@ResponseBody
	public int deleteShoppingCart(@RequestParam Map<String,Object> map) {
		int result = 0;
		String itemNo = (String)map.get("itemNo");
		result = ordersDao.deleteOrder(itemNo);
		
		return result;
	}
	
	//주문번호를 DB에서 생성하고 결과를 반환한다.
	@RequestMapping("/GetOrderGroupNo.do")
	@ResponseBody
	public int getOrderGroupNo() {
		int order_Group_No;
		order_Group_No = ordersDao.getOrderGroupNo();
		return order_Group_No;
	}
	
	// 결제하려는 찜한 책들을 DB에 같은 orderGroupNo에 묶어서를 넣어준다.
	@RequestMapping("/setOrderGroupNo.do")
	@ResponseBody
	public int setOrderGroupNo(OrdersDto ordersDto) {
		int result = 0;
		result = ordersDao.setOrderGroupNo(ordersDto);
		return result;
	}

	//////////////////////////////// 결제 관련 ////////////////////////////////
	// 주문 결제페이지로 이동한다
	@RequestMapping("/OrderPayForm.do")
	public String orderPayForm(HttpSession session, HttpServletResponse response) throws IOException {
		memberDto = (MemberDto)session.getAttribute("loggedMember");
		if(memberDto == null) {
			ScriptWriterUtil.alertAndBack(response, "로그인 후 이용해주세요");
		}
		return "orders/orders_pay";
	}
	
	// 결제하려는 상품들을 반환한다.
	@RequestMapping("/getOrdersList.do")
	@ResponseBody
	public Map<String, Object> getOrdersList(OrdersDto ordersDto){
		 Map<String, Object> hashMap = new HashMap<String, Object>();
		 List<OrdersDto> orderList = ordersDao.getOrderList(ordersDto);
		 
		 hashMap.put("orderList", orderList);
		 return hashMap;
	}
	
	
}
