package ridi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

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
     MemberDto loggedMember;


  @RequestMapping("/MemberJoin.do")
  public String memberJoin(@ModelAttribute MemberDto memberDto, HttpServletResponse response) throws IOException {
     //logger.info("memberDto==={}", memberDto.toString());
     memberDto.setAddress(memberDto.getAddress01()+" "+memberDto.getAddress02());
     memberDto.setHp(memberDto.getPhoneNumber()+"-"+memberDto.getPhoneMiddleNumber()+"-"+memberDto.getPhoneLastNumber());
     int result = memberDao.insertMember(memberDto);
     if(result>0) {
        ScriptWriterUtil.alertAndNext(response, "ȸ�������� �Ǿ����ϴ�.", "index");
     } else {
        ScriptWriterUtil.alertAndBack(response, "ȸ�����Կ� �����Ͽ����ϴ�.");
     }
     return null;
  }
  
  @RequestMapping("/MemberJoinForm.do")
  public String memberWriteForm() {
     return "member/member_Join";
  }
  
  @RequestMapping("/MemberLoginForm.do")
  public String memberLoginForm() {
	  return "member/member_Login";
  }
}
