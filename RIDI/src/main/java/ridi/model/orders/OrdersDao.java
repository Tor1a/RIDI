package ridi.model.orders;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class OrdersDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//////////////////////////////카트/찜하기 관련 ////////////////////////////////
	// 찜한 내용을 DB에 저장
	public int insertOrder(OrdersDto ordersDto) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertOrder", ordersDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	// 사용자별 찜한 내용들을 출력한다.
	public List<OrdersDto> getAllCartList(String id){
		List<OrdersDto> shoppingCartList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		shoppingCartList = sqlSession.selectList("getAllCartList",id);
		sqlSession.close();
		
		return shoppingCartList;
	}
	
	// 찜한 내용을 1개 삭제
	public int deleteOrder(String itemNo) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteOrder",itemNo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	// 주문번호를 DB에서 생성하고 결과를 반환한다.
	public int getOrderGroupNo() {
		int order_Group_No;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		order_Group_No = sqlSession.selectOne("getOrderGroupNo");
		sqlSession.close();
		return order_Group_No;
	}
	
	// 결제하려는 찜한 책들을 DB에 같은 orderGroupNo에 묶어서를 넣어준다.
	public int setOrderGroupNo(OrdersDto ordersDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("setOrderGroupNo",ordersDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	////////////////////////////////결제 관련 ////////////////////////////////
	public List<OrdersDto> getOrderList(OrdersDto ordersDto){
		List<OrdersDto> orderList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		orderList = sqlSession.selectList("getOrderList",ordersDto);
		sqlSession.close();
		return orderList;
	}
}
