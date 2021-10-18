package ridi.controller;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;
import ridi.model.member.MemberDto;
import ridi.utlils.Mail;
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
     
     @Autowired
     MemberDto tempMemberDto;


  //회원가입 페이지로 이동시킨다.
  @RequestMapping("/MemberJoinForm.do")
  public String memberWriteForm() {
     return "member/member_Join";
  }
  
  //ID 중복체크를 실행합니다.
  @RequestMapping("/idDuplicationCheck.do")
  @ResponseBody
  public MemberDto idDuplicationCheck(MemberDto memberDto) {
	  tempMemberDto = memberDao.idDuplicationCheck(memberDto);
	  return tempMemberDto;
  }
  
  //Email 인증번호를 생성합니다.
  @RequestMapping("/generateEmailAuthNum.do")
  @ResponseBody
  public int generateEmailAuthNum() {
	  double random = Math.random()*1000000;
	  Mail.NaverMail("lkoosss@gmail.com", "메일인증 테스트", "으아아아아");
	  return (int)random;
  }
  
  //로그인 페이지로 이동시킨다.
  @RequestMapping("/MemberLoginForm.do")
  public String memberLoginForm() {
	  return "member/member_Login";
  }
  
  //로그인 동작을 실행한다.
  @RequestMapping("/MemberLogin.do")
  public void memberLogin(MemberDto memberDto,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
	  
	  loggedMemberDto = memberDao.getLoggedMember(memberDto);
	  if(loggedMemberDto != null) {
		  session.setAttribute("loggedMember", loggedMemberDto);
		  ScriptWriterUtil.alertAndNext(response, "로그인되었습니다.", "/RIDI");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "아이디 또는 비밀번호가 맞지 않습니다.");
	  }
  }
  
  //로그아웃 동작을 실행한다.
  @RequestMapping("/MemberLogout.do")
  public String memberLogout(HttpSession session) {
	  session.invalidate();
	  return "index";
  }
  
  //회원가입 동작을 실행한다.
  @RequestMapping("/MemberJoin.do")
  public void memberJoin(MemberDto memberDto,HttpServletRequest request, HttpServletResponse response) throws IOException {
	  memberDto.setRRN(memberDto.getRrn_First()+"-"+memberDto.getRrn_Last());
	  memberDto.setAddress(memberDto.getAddress01()+"/"+memberDto.getAddress02());
	  memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneLastNumber());
	  
	  int result = memberDao.insertMember(memberDto);
	  if(result > 0) {
		  ScriptWriterUtil.alertAndNext(response, "회원가입이 완료 되었습니다.", "/RIDI");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "회원가입 실패");
	  }
  }
  
  //회원정보 변경 페이지로 이동한다.
  @RequestMapping("/MemberInfoModifyForm.do")
  public String memberInfoModifyForm() {
	  return "member/member_Modify";
  }
 
  //회원정보 변경 동작을 실행한다.
  @RequestMapping("/MemberInfoModify.do")
  public void memberInfoModify(MemberDto memberDto,HttpServletResponse response,HttpSession session) throws IOException {
	  MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMember");
	  
	  memberDto.setId(loggedMemberDto.getId());
	  memberDto.setAddress(memberDto.getAddress01()+"/"+memberDto.getAddress02());
	  memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneLastNumber());
	  
	  if(memberDto.getPassword().isBlank()) {
		  memberDto.setPassword(loggedMemberDto.getPassword());
	  } 
	  
	  int result = memberDao.modifyMember(memberDto);
	  
	  if(result > 0) {
		  loggedMemberDto = memberDao.getLoggedMember(memberDto);
		  session.setAttribute("loggedMember", loggedMemberDto);
		  ScriptWriterUtil.alertAndNext(response, "회원정보가 정상적으로 수정되었습니다.", "MemberInfoModifyForm.do");
	  } else {
		  ScriptWriterUtil.alertAndBack(response, "알수 없는 이유로 정보가 수정되지 못했습니다.");
	  }
  }
  
  // 회원탈퇴 페이지로 이동한다.
  @RequestMapping("/MemberDeleteForm.do")
  public String memberDeleteForm() {
	  return "member/member_delete";
  }
  
  // 회원탈퇴 동작을 실행한다.
  @RequestMapping("/MemberDelete.do")
  public void memberDelete(MemberDto memberDto,HttpServletResponse response,HttpSession session) throws IOException {
	  MemberDto loggedMemberDto = (MemberDto)session.getAttribute("loggedMember");
	  memberDto.setId(loggedMemberDto.getId());
	  
	  int result = memberDao.deleteMember(memberDto);
	  if(result > 0) {
		  session.invalidate();
		  ScriptWriterUtil.alertAndNext(response, "정상적으로 탈퇴가 되었습니다.", "/RIDI");
	  } else {
		  ScriptWriterUtil.alertAndNext(response, "비밀번호를 확인해주세요","MemberDeleteForm.do");
	  }
  }
}
