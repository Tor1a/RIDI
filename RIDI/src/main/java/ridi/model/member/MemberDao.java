package ridi.model.member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	  
	   @Autowired
	   private SqlSessionFactory sqlSessionFactory;
	   
	   public int insertMember(MemberDto memberDto) {
	      int result = 0;
	      
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      result = sqlSession.insert("insertMember", memberDto);
	      sqlSession.commit();
	      sqlSession.close();
	      
	      return result;
	   }
	   public MemberDto getLoggedMember(MemberDto memberDto) {
	      MemberDto loggedMember = null;
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      loggedMember = sqlSession.selectOne("getLoggedMember", memberDto);
	      sqlSession.close();
	      return loggedMember;
	   }
	   
	   //오성식이 임시 생성
	   public MemberDto getOneMember() {
		   MemberDto memberDto = null;
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   memberDto = sqlSession.selectOne("getOneMember");
		   sqlSession.close();
		   return memberDto;
	   }

}
