package ridi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ridi.model.review.ReviewDao;
import ridi.model.review.ReviewDto;
import ridi.utlils.ScriptWriterUtil;

@Controller
@Slf4j
public class ReviewController {

	@Autowired
	ReviewDto reviewDto;
	
	@Autowired
	ReviewDao reviewDao;
	
	//리뷰 작성 페이지로 이동한다.
	@RequestMapping("/ReviewWriteForm.do")
	public String reviewWriteForm() {
		return "review/review_Write";
	}
	
	// 리뷰 작성시 DB에 저장한다.
	@RequestMapping("/ReviewWrite.do")
	public void reviewWrite(ReviewDto reviewDto,HttpServletResponse response) throws IOException {
		int result = 0;
		result = reviewDao.reviewWrite(reviewDto);
		
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "리뷰가 정상적으로 등록되었습니다.", "ReviewWriteForm.do");
		} else {
			ScriptWriterUtil.alertAndBack(response, "리뷰 등록에 실패하였습니다.");
		}
	}
	
	// 리뷰 목록들을 출력한다.
	@RequestMapping("/ReviewList.do")
	@ResponseBody
	public Map<String, Object> getAllReview(){
		Map<String, Object> hashMap = new HashMap<String, Object>();
		List<ReviewDto> reviewList =  reviewDao.getAllReview();
		hashMap.put("reviewList", reviewList);
		return hashMap;
	}
	
	// 리뷰 삭제를 실행한다.
	@RequestMapping("/ReviewDelete.do")
	@ResponseBody
	public int deleteReview(ReviewDto reviewDto) {
		int result = 0;
		result = reviewDao.deleteReview(reviewDto);
		return result;
	}
}