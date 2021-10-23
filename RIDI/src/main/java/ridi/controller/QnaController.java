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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import ridi.model.qna.QnaDao;
import ridi.model.qna.QnaDto;
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
	
	@RequestMapping("/QnaWrite.do")
	public String qnaWrite(QnaDto qnaDto, HttpServletResponse response) throws IOException {
		int result = qnaDao.insertQna(qnaDto);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "질문이 등록되었습니다", "QnaList.do");
		}else {
			ScriptWriterUtil.alertAndBack(response, "질문이 등록되지않았습니다");
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
	
	@RequestMapping("/QnaReply.do")
	public String qnaReply() {
		
		return "qna/qna_Reply";
	}
	
	
	@RequestMapping("/QndDelete.do")
	   public String qnaDelete(HttpServletResponse response,HttpServletRequest request) throws IOException {
	      int no = Integer.parseInt(request.getParameter("no"));
	      String password = request.getParameter("password");
	      String userPassword = qnaDao.getPassword(no);
	      System.out.println(no+"================================"+password);
	      if(userPassword.equals(password)) {
	         int result = qnaDao.deleteQna(no);
	         if(result > 0) {
	            ScriptWriterUtil.alertAndNext(response, "질문이삭제되었습니다", "QnaList.do");
	         }else {
	            ScriptWriterUtil.alertAndBack(response, "질문삭제가 안되었습니다.");
	         }
	      }else {
	         ScriptWriterUtil.alertAndBack(response, "비밀번호를 확인해 주세요");
	      }
	      return null;
	   }
	
/////////////////////////////섬머노트////////////////////////
@RequestMapping("/SummerNoteFileUpload.do")
@ResponseBody
public Map<String,Object> sendImgFile(
		MultipartFile summerNoteImage, 
		HttpServletResponse response,
		HttpServletRequest request
	 ) {

String context = request.getContextPath();
String fileRoot =  "C:\\summernoteImages\\";
String originalFileName =  summerNoteImage.getOriginalFilename(); 
String extention =  FilenameUtils.getExtension(originalFileName);
String savedFileName = UUID.randomUUID()+"."+extention; 
File targetFile = new File(fileRoot+savedFileName); 
String dbFileName = context+"/SummernoteImages/"+savedFileName; 

Map<String,Object> hashMap = new HashMap<String,Object>();
try {
InputStream fileStream = summerNoteImage.getInputStream();
FileUtils.copyInputStreamToFile(fileStream, targetFile);
hashMap.put("url",context+"/SummernoteImages/"+savedFileName);
hashMap.put("responseCode","success");
} catch (IOException e) {
FileUtils.deleteQuietly(targetFile);
hashMap.put("responseCode","error");
e.printStackTrace();
}
return hashMap;
}
}
