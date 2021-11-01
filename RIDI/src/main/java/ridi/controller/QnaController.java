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
	
	// 게시글 작성 기능
	@RequestMapping("/QnaWrite.do")
	public String qnaWrite(QnaDto qnaDto, HttpServletResponse response) throws IOException {
			int result = qnaDao.insertQna(qnaDto);
			if(result > 0) {
				ScriptWriterUtil.alertAndNext(response, "게시글이 작성되었습니다", "QnaList.do");
			}else {
				ScriptWriterUtil.alertAndBack(response, "게시글이 작성되지 않았습니다.");
			}
			return null;
		}
	
	// 게시글 리스트
	@RequestMapping("/QnaList.do")
		public String QnaList(Model model, HttpServletRequest request) {
			
			String clickedPage = request.getParameter("clickedPage");
			if(clickedPage == null) {
				clickedPage = "1";
			}
			int currentPage = Integer.parseInt(clickedPage);
			
			int total= 0 ;
			int listPerCount = 7;
			int pageGroupCount = 5;
			
			total = qnaDao.getTotal();
			int lastPage = 0;
			if((int)(total % listPerCount) ==0) {
				lastPage = (int)(total / listPerCount);
			} else {
				lastPage = (int)(total / listPerCount) + 1;
			}
			
			
			int startPage = (int)((currentPage - 1)/pageGroupCount)*pageGroupCount + 1;
			int endPage = startPage + pageGroupCount -1;
			
			if(endPage > lastPage) {
				endPage = lastPage;
			}
			
			int start = (currentPage -1)*listPerCount+1;
			int end = start+listPerCount;
			log.info("start========={}",start);
			log.info("end========{}",end);
			
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
	

	// 리스트에서 클릭시 게시글 하나만 보여줌
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
	// 게시글 삭제기능
	@RequestMapping("/QndDelete.do")
	@ResponseBody
	   public int qnaDelete(QnaDto qnaDto, HttpServletResponse response) throws IOException {
	     int result = 0;
	      String userPassword = qnaDao.getPassword(qnaDto.getNo());
	     
	      if(userPassword.equals(qnaDto.getPassword())) {
	         result = qnaDao.deleteQna(qnaDto);
	      }
	      return result;
	   }
	
	// 댓글기능
	
		// 댓글 작성
		@RequestMapping("/ReplyWrite.do")
		@ResponseBody
		public int replyWrite(ReplyDto replyDto){
			int result = 0;
			result = replyDao.insertReply(replyDto);
			
			return result;
		}
		
		// 댓글 리스트 
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
		
		// 댓글 삭제
		@RequestMapping("/DeleteReply.do")
		@ResponseBody
		public int deleteReply(ReplyDto replyDto) {
			int result =0;
			result = replyDao.deleteReply(replyDto);
			
			
			return result;
		}
		
	
	
	//검색 기능
	@RequestMapping("/QnaSearchList.do")
	public String getQnaSearchList(QnaDto qnaDto)  {
		return "qna/qna_Search";
	}
	
	
}
