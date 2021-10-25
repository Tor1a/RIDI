package ridi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	//view
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	// 밑에는 삭제해야할 것들
	@RequestMapping("BookOrderForm.do")
	public String seven() {
		return "book/book_order";
	}
	
	@RequestMapping("/qna_Delete.do")
	public String one() {
		return "qna/qna_Delete";
	}
	
	@RequestMapping("/qna_List.do")
	public String two() {
		return "qna/qna_List";
	}
	
	@RequestMapping("/qna_Reply.do")
	public String three() {
		return "qna/qna_Reply";
	}
	
	@RequestMapping("/qna_Search.do")
	public String four() {
		return "qna/qna_Search";
	}
	
	@RequestMapping("/qna_View.do")
	public String five() {
		return "qna/qna_View";
	}
	
	@RequestMapping("/qna_Write.do")
	public String six() {
		return "qna/qna_Write";
	}
	
}
