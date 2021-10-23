package ridi.model.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ReviewDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	// 리뷰 작성시 DB에 저장한다.
	public int reviewWrite(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("reviewWrite",reviewDto);
		sqlSession.close();
		return result;
	}
	
	// 리뷰 목록들을 출력한다.
	public List<ReviewDto> getAllReview(){
		List<ReviewDto> reviewList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		reviewList = sqlSession.selectList("getAllReview");
		return reviewList;
	}
	
	// 리뷰 삭제를 실행한다.
	public int deleteReview(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteReview",reviewDto);
		return result;
	}
}

