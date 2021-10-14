package ridi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;
import ridi.model.member.MemberDto;
import ridi.utlils.ScriptWriterUtil;

@Controller
@Slf4j
public class MemberController {
	 @Autowired
     MemberDao memberDao;
     
     @Autowired
     MemberDto memberDto;
     
     @Autowired
     MemberDto loggedMemberDto;


//  @RequestMapping("/MemberJoin.do")
//  public String memberJoin(@ModelAttribute MemberDto memberDto, HttpServletResponse response) throws IOException {
//     //logger.info("memberDto==={}", memberDto.toString());
//     memberDto.setAddress(memberDto.getAddress01()+" "+memberDto.getAddress02());
//     memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneLastNumber());
//     int result = memberDao.insertMember(memberDto);
//     if(result>0) {
//        ScriptWriterUtil.alertAndNext(response, "ȸ�������� �Ǿ����ϴ�.", "index");
//     } else {
//        ScriptWriterUtil.alertAndBack(response, "ȸ�����Կ� �����Ͽ����ϴ�.");
//     }
//     return null;
//  }
  
  @RequestMapping("/MemberJoinForm.do")
  public String memberWriteForm() {
     return "member/member_Join";
  }
  
  @RequestMapping("/MemberLoginForm.do")
  public String memberLoginForm() {
	  return "member/member_Login";
  }
  
  @RequestMapping("/MemberLogin.do")
  public void memberLogin(MemberDto memberDto,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
	  
	  loggedMemberDto = memberDao.getLoggedMember(memberDto);
	  log.info("loggedMemberDto ======================================{}",loggedMemberDto);
	  if(loggedMemberDto != null) {
		  session.setAttribute("loggedMember", loggedMemberDto);
		  ScriptWriterUtil.alertAndNext(response, "로그인되었습니다.", "/RIDI");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "아이디 또는 비밀번호가 맞지 않습니다.");
	  }
  }
  
  @RequestMapping("/MemberJoin.do")
  public void memberJoin(MemberDto memberDto,HttpServletRequest request, HttpServletResponse response) throws IOException {
	  memberDto.setRRN(memberDto.getRrn_first()+"-"+memberDto.getRrn_last());
	  memberDto.setAddress(memberDto.getAddress01()+" / "+memberDto.getAddress02());
	  memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneLastNumber());
	  
	  int result = memberDao.insertMember(memberDto);
	  if(result > 0) {
		  ScriptWriterUtil.alertAndNext(response, "회원가입이 완료 되었습니다.", "/RIDI");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "회원가입 실패");
	  }
  }
  
 
}
