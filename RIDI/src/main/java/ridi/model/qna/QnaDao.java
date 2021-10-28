package ridi.model.qna;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
public class QnaDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//session factory 받기
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public List<QnaDto> getAllList(int start, int end){
		HashMap<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		List<QnaDto> qnaList = null;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaList = sqlSession.selectList("getAllList",page);
		

		
		sqlSession.close();
		return qnaList;
	}
	
	public int getTotal() {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getTotal");
		sqlSession.close();
		
		return result;
	}
	
	public int insertQna(QnaDto qnaDto) {
		int result = 0 ;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result =  sqlSession.insert("insertQna",qnaDto);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public int updateReadCount(int no) {
		int result =0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("updateReadCount",no);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public QnaDto getQnaSelectOne(int no) {
		QnaDto qnaDto = null;
		updateReadCount(no);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("getQnaSelectOne",no);
		sqlSession.close();
		
		return qnaDto;
	}
	
	public QnaDto prevQnaDto(int num) {
		QnaDto qnaDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("prevQnaDto",num);
		sqlSession.close();
		
		return qnaDto;
	}
	public QnaDto nextQnaDto(int num) {
		QnaDto qnaDto = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		qnaDto = sqlSession.selectOne("nextQnaDto",num);
		sqlSession.close();
		
		return qnaDto;		
	}
	
	public String getPassword(int no) {
		String password = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		password = sqlSession.selectOne("getPassword", no);
		sqlSession.close();
		return password;
	}
	
	public int deleteQna(int no) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteQna",no);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public List<Object> getQnaSearchList(QnaDto qnaDto){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Object> qnaSearchList = sqlSession.selectList("getSearchAllList",qnaDto);
		return qnaSearchList;
	}
	
}
