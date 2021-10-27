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
		
		return result;
	}
}
