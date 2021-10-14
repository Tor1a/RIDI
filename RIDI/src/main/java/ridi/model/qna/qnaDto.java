package ridi.model.qna;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class qnaDto {
	private int no;
	private String content;
	private int book_No;
	private String writer_Id;
	private String reply_Ok;
	public qnaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public qnaDto(int no, String content, int book_No, String writer_Id, String reply_Ok) {
		super();
		this.no = no;
		this.content = content;
		this.book_No = book_No;
		this.writer_Id = writer_Id;
		this.reply_Ok = reply_Ok;
	}
	@Override
	public String toString() {
		return "qnaDto [no=" + no + ", content=" + content + ", book_No=" + book_No + ", writer_Id=" + writer_Id
				+ ", reply_Ok=" + reply_Ok + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBook_No() {
		return book_No;
	}
	public void setBook_No(int book_No) {
		this.book_No = book_No;
	}
	public String getWriter_Id() {
		return writer_Id;
	}
	public void setWriter_Id(String writer_Id) {
		this.writer_Id = writer_Id;
	}
	public String getReply_Ok() {
		return reply_Ok;
	}
	public void setReply_Ok(String reply_Ok) {
		this.reply_Ok = reply_Ok;
	}
	
	
}
