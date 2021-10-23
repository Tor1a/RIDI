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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import ridi.model.book.BookDao;
import ridi.model.book.BookDto;
import ridi.utlils.ScriptWriterUtil;

@Slf4j
@Controller
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BookDto bookDto;
	
	@Autowired
	BookDao bookDao;
	
	@RequestMapping("/BookWriteForm.do")
	public String bookWriteForm() {
		return "book/book_Write";
	}
	
	
	@RequestMapping("/BookWrite.do")
	public String bookWrite(BookDto bookDto, MultipartFile multipartFile ,
											HttpServletResponse response, 
											HttpServletRequest request) throws IOException {
		String context = request.getContextPath();
		String fileRoot = "C:\\bookImage\\";
		String originalFileName = multipartFile.getOriginalFilename();
		String extention = FilenameUtils.getExtension(originalFileName);
		String savedFileName = UUID.randomUUID()+"."+extention;
		File targetFile = new File(fileRoot+savedFileName);
		String dbFileName = context + "/bookImage/" + savedFileName;
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookDto.setBook_RealImage(originalFileName);
		bookDto.setBook_Image(dbFileName);
		
		int result = bookDao.insertBook(bookDto);
		
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "등록 되었습니다.", "/RIDI");
		} else {
			ScriptWriterUtil.alertAndBack(response, "글이 등록되지 않았습니다.");
		}
		
		logger.info("bookDto === {}", bookDto);
		logger.info("result === {}", result);
		
		return null;
	}
	
	/*
	 * @RequestMapping("/BookList.do") public String BookList() { return
	 * "book/book_List"; }
	 */
	
	// 메인 SLIDER 띄우는 json
	@RequestMapping("/BookJsonSliderList.do")
	@ResponseBody
	public Map<String, List<BookDto>> BookJsonSliderList(){
		Map<String, List<BookDto>> hashMap = null;
		
		List<BookDto> bookList = bookDao.getAdvSlider();
		hashMap = new HashMap<String, List<BookDto>>();
		hashMap.put("bookList", bookList);
		
		return hashMap;
	}
	// 신작 추천 controller
	@RequestMapping("/NewBookJsonList.do")
	@ResponseBody
	public Map<String, List<BookDto>> NewBookJsonList(){
		Map<String, List<BookDto>> hashMap = null;
		
		List<BookDto> newBookList = bookDao.getNewBook();
		hashMap = new HashMap<String, List<BookDto>>();
		hashMap.put("newBookList", newBookList);
		
		return hashMap;
	}
	
	// 전부 띄우는 json
	@RequestMapping("/BookJsonList.do")
	@ResponseBody
	public Map<String, List<BookDto>> BookJsonList(){
		Map<String, List<BookDto>> hashMap = null;
		
		List<BookDto> bookList = bookDao.getAllBook();
		hashMap = new HashMap<String, List<BookDto>>();
		hashMap.put("bookList", bookList);
		
		return hashMap;
	}
	
	
	@RequestMapping("/BookInfo.do")
	public String getOneBook(int no, Model model) {
		
		bookDto = bookDao.getOneBook(no);
		model.addAttribute("bookDto", bookDto);
		
		return "book/book_Info";
	}
	
	@RequestMapping("/BookModifyForm.do")
	public String bookModifyForm() {
		return "book/book_Modify";
	}
	
	
	// 비밀번호 받아서 수정..? 11-review 참고
	@RequestMapping("/BookModify.do")
	public String bookModify(BookDto bookDto, MultipartFile multipartFile ,
			HttpServletResponse response, 
			HttpServletRequest request) throws IOException {
		
		
		String context = request.getContextPath();
		String fileRoot = "C:\\bookImage\\";
		String originalFileName = multipartFile.getOriginalFilename();
		String extention = FilenameUtils.getExtension(originalFileName);
		String savedFileName = UUID.randomUUID()+"."+extention;
		File targetFile = new File(fileRoot+savedFileName);
		String dbFileName = context + "/bookImage/" + savedFileName;
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bookDto.setBook_RealImage(originalFileName);
		bookDto.setBook_Image(dbFileName);
		System.out.println();
		int result = bookDao.modifyBook(bookDto);
		
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "글이 수정 되었습니다.", "BookList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "글 수정 실패했습니다.");
		}
		
		return null;
	}
	
	@RequestMapping("/BookDelete.do")
	public String deleteBook(int no, HttpServletResponse response ) throws IOException {
		int result = bookDao.deleteBook(no);
		
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "삭제되었습니다.", "BookList.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "삭제 실패 하였습니다.");
		}
		
		return null;
	}
	
	
}