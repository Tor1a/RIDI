package ridi.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("QnaWriteForm.do")
	public String qnaWriteForm() {
		return "qna/qna_Write";
				
	}
	@RequestMapping("QnaWrite.do")
	public String qnaWrite(QnaDto qnaDto, HttpServletResponse response) throws IOException {
		int result = qnaDao.insertQna(qnaDto);
		if(result > 0) {
			ScriptWriterUtil.alertAndNext(response, "질문이 등록되었습니다", "QnaList.do");
		}else {
			ScriptWriterUtil.alertAndBack(response, "질문이 등록되지않았습니다");
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
