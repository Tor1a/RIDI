package ridi.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import ridi.model.qna.QnaDao;
import ridi.model.qna.QnaDto;
import ridi.model.qna.ReplyDao;
import ridi.model.qna.ReplyDto;
import ridi.model.qna.SearchDto;
import ridi.utlils.ScriptWriterUtil;

@Controller
@Slf4j
public class QnaController {

	@Autowired
	QnaDao qnaDao;
	
	@Autowired
	QnaDto qnaDto;
	
	@Autowired
	QnaDto prevQnaDto;
	
	@Autowired
	QnaDto nextQnaDto;
	
	@Autowired
	ReplyDto replyDto;
	
	@Autowired
	ReplyDao replyDao; 
	
	
	@RequestMapping("/QnaWriteForm.do")
	public String qnaWriteForm() {
		return "qna/qna_Write";
				
	}
	
	@RequestMapping("/QnaList.do")
		public String QnaList(Model model, HttpServletRequest request) {
			
			String clickedPage = request.getParameter("clickedPage");
			if(clickedPage == null) {
				clickedPage = "1";
			}
			int currentPage = Integer.parseInt(clickedPage);
			
			int total= 0 ;
			int listPerCount = 5;
			int pageGroupCount = 10;
			
			total = qnaDao.getTotal();
			int lastPage = (int)(total / listPerCount) + 1;
			
			int startPage = (int)((currentPage - 1)/pageGroupCount)*pageGroupCount + 1;
			int endPage = startPage + pageGroupCount -1;
			
			if(endPage > lastPage) {
				endPage = lastPage;
			}
			
			int start = (currentPage -1)*listPerCount+1;
			int end = start+listPerCount;
			
			List<QnaDto> qnaList = null;
			qnaList = qnaDao.getAllList(start,end);
			
			
			model.addAttribute("qnaList",qnaList);
			model.addAttribute("lastPage",lastPage);
			model.addAttribute("listPerCount",listPerCount);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("pageGroupCount",pageGroupCount);
			model.addAttribute("total",total);
//			System.out.println("total==="+total);
//			System.out.println("startPage==="+startPage);
//			System.out.println("endPage==="+endPage);
//			System.out.println("qnaList==="+qnaList);
			
			
		return "qna/qna_List";
		}
	// 글작성 기능
	
	@RequestMapping("/QnaWrite.do")
	public String qnaWrite(QnaDto qnaDto, HttpServletResponse response) throws IOException {
		int result = qnaDao.insertQna(qnaDto);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "吏덈Ц�씠 �벑濡앸릺�뿀�뒿�땲�떎", "QnaList.do");
		}else {
			ScriptWriterUtil.alertAndBack(response, "吏덈Ц�씠 �벑濡앸릺吏��븡�븯�뒿�땲�떎");
		}
		return null;
	}

	
	@RequestMapping("/QnaView.do")
		public String qnaView(int no, int clickedPage, int num, Model model,HttpServletRequest request) {
			
		qnaDto = qnaDao.getQnaSelectOne(no);
		
		
		prevQnaDto = qnaDao.prevQnaDto(num);
		nextQnaDto = qnaDao.nextQnaDto(num);	
		model.addAttribute("clickedPage",clickedPage);
		model.addAttribute("qnaDto", qnaDto);
		model.addAttribute("prevQnaDto",prevQnaDto);
		model.addAttribute("nextQnaDto",nextQnaDto);
		
		System.out.println("clickedPage=="+clickedPage);
		System.out.println("qnaDto=="+qnaDto);
		
		return "qna/qna_View";
		
	}
	// 삭제기능
	
	@RequestMapping("/QndDelete.do")
	   public String qnaDelete(HttpServletResponse response,HttpServletRequest request) throws IOException {
	      int no = Integer.parseInt(request.getParameter("no"));
	      String password = request.getParameter("password");
	      String userPassword = qnaDao.getPassword(no);
	      System.out.println(no+"================================"+password);
	      if(userPassword.equals(password)) {
	         int result = qnaDao.deleteQna(no);
	         if(result > 0) {
	            ScriptWriterUtil.alertAndNext(response, "吏덈Ц�씠�궘�젣�릺�뿀�뒿�땲�떎", "QnaList.do");
	         }else {
	            ScriptWriterUtil.alertAndBack(response, "吏덈Ц�궘�젣媛� �븞�릺�뿀�뒿�땲�떎.");
	         }
	      }else {
	         ScriptWriterUtil.alertAndBack(response, "鍮꾨�踰덊샇瑜� �솗�씤�빐 二쇱꽭�슂");
	      }
	      return null;
	   }
	
	//검색 기능
	@RequestMapping("QnaSearchList.do")
	public String getQnaSearchList(QnaDto qnaDto, Model model, HttpServletRequest request)  {
		
		List<Object> qnaSearchList = null;
		
		qnaSearchList = qnaDao.getQnaSearchList(qnaDto);
		//hashMap.put("qnaSearchList", qnaSearchList);
		
		String clickedPage = request.getParameter("clickedPage");
		if(clickedPage == null) {
			clickedPage = "1";
		}
		int currentPage = Integer.parseInt(clickedPage);
		
		int total= 0 ;
		int listPerCount = 5;
		int pageGroupCount = 10;
		
		total = qnaDao.getTotal();
		int lastPage = (int)(total / listPerCount) + 1;
		
		int startPage = (int)((currentPage - 1)/pageGroupCount)*pageGroupCount + 1;
		int endPage = startPage + pageGroupCount -1;
		
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		
		int start = (currentPage -1)*listPerCount+1;
		int end = start+listPerCount;
		
		List<QnaDto> qnaList = null;
		qnaList = qnaDao.getAllList(start,end);
		
		
		model.addAttribute("qnaList",qnaList);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("listPerCount",listPerCount);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("pageGroupCount",pageGroupCount);
		model.addAttribute("total",total);
		
		return "hi";
	}
	
	// 댓글기능
	
	@RequestMapping("/ReplyWrite.do")
	@ResponseBody
	public int replyWrite(ReplyDto replyDto){
		int result = 0;
		result = replyDao.insertReply(replyDto);
		
		return result;
	}
	
	
	@RequestMapping("/ReplySelectAll.do")
	@ResponseBody
	public Map<String,Object> getAllReply(@RequestParam Map<String,Object> map) {
		Map<String,Object> hashMap = new HashMap<String,Object>();
		List<ReplyDto> replyList = null;
		
		String boardId = (String)map.get("boardId");
		replyList = replyDao.getAllReply(Integer.parseInt(boardId));
		hashMap.put("replyList", replyList);
		return hashMap;
	}
	
	
	
	
}
