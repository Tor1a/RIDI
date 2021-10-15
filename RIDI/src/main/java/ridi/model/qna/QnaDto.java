package ridi.model.qna;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class QnaDto {
	private int no;
	private String writerId;
	public String subject;
	public String password;
	private Date regDate;
	private int reGroup;
	private int reStep;
	private int reLevel;
	private int readCount;
	private String contents;
	private int num;
	public QnaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaDto(int no, String write_Id, String subject, String password, Date regDate, int reGroup, int reStep,
			int reLevel, int readCount, String contents, int num) {
		super();
		this.no = no;
		this.writerId = writerId;
		this.subject = subject;
		this.password = password;
		this.regDate = regDate;
		this.reGroup = reGroup;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.readCount = readCount;
		this.contents = contents;
		this.num = num;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReGroup() {
		return reGroup;
	}
	public void setReGroup(int reGroup) {
		this.reGroup = reGroup;
	}
	public int getReStep() {
		return reStep;
	}
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	public int getReLevel() {
		return reLevel;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "QnaDto [no=" + no + ", writerId=" + writerId + ", subject=" + subject + ", password=" + password
				+ ", regDate=" + regDate + ", reGroup=" + reGroup + ", reStep=" + reStep + ", reLevel=" + reLevel
				+ ", readCount=" + readCount + ", contents=" + contents + ", num=" + num + "]";
	}
	
	
	
	}
	