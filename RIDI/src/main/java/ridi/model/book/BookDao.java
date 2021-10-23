package ridi.model.book;

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
@Slf4j
public class BookDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	public int insertBook(BookDto bookDto) {
		
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertBook", bookDto);
		sqlSession.commit();
	    sqlSession.close();
		
		logger.info("result==={}", result);
		return result;
	}
	// 모든 책 출력
	public List<BookDto> getAllBook(){
		List<BookDto> bookList = null;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookList = sqlSession.selectList("getAllBook");
		sqlSession.close();
		
		return bookList;
	}
	// 메인 슬라이더
	public List<BookDto> getAdvSlider(){
		List<BookDto> bookList = null;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookList = sqlSession.selectList("getAdvSlider");
		sqlSession.close();
		
		return bookList;
	}
	public List<BookDto> getNewBook(){
		List<BookDto> newBookList = null;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		newBookList = sqlSession.selectList("getNewBook");
		sqlSession.close();
		
		return newBookList;
	}
	// info 페이지
	public BookDto getOneBook(int no) {
		BookDto bookDto = null;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		bookDto = sqlSession.selectOne("getOneBook", no);
		sqlSession.close();
		
		return bookDto;
	}
	// 책 수정 페이지
	public int modifyBook(BookDto bookDto) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("modifyBook", bookDto);
		sqlSession.commit();
	    sqlSession.close();
		
		return result;
	}
	// 책 삭제 페이지
	public int deleteBook(int no) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteBook", no);
		sqlSession.commit();
	    sqlSession.close();
		
		return result;
	}
	
}