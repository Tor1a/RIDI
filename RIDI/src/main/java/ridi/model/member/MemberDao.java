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
	   
	   public int modifyMember(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   result = sqlSession.update("modifyMember",memberDto);
		   sqlSession.commit();
		   sqlSession.close();
		   return result;
	   }
	   
	   public int deleteMember(MemberDto memberDto) {
		   int result = 0;
		   
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   result = sqlSession.delete("deleteMember",memberDto);
		   sqlSession.commit();
		   sqlSession.close();
		   
		   return result;
	   }

	   public MemberDto idDuplicationCheck(MemberDto memberDto) {
		   SqlSession sqlSession = sqlSessionFactory.openSession();
		   
		   MemberDto tempMemberDto = sqlSession.selectOne("idDuplicationCheck",memberDto);
		   return tempMemberDto;
	   }
}
