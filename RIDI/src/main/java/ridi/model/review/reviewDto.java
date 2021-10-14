package ridi.model.review;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class reviewDto {
	private int no;
	private int book_No;
	private String contents;
	private String wirter_Id;
	private int star_Rating;
	private String password;
	private Date review_Date;
	public reviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public reviewDto(int no, int book_No, String contents, String wirter_Id, int star_Rating, String password,
			Date review_Date) {
		super();
		this.no = no;
		this.book_No = book_No;
		this.contents = contents;
		this.wirter_Id = wirter_Id;
		this.star_Rating = star_Rating;
		this.password = password;
		this.review_Date = review_Date;
	}
	@Override
	public String toString() {
		return "reviewDto [no=" + no + ", book_No=" + book_No + ", contents=" + contents + ", wirter_Id=" + wirter_Id
				+ ", star_Rating=" + star_Rating + ", password=" + password + ", review_Date=" + review_Date + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBook_No() {
		return book_No;
	}
	public void setBook_No(int book_No) {
		this.book_No = book_No;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWirter_Id() {
		return wirter_Id;
	}
	public void setWirter_Id(String wirter_Id) {
		this.wirter_Id = wirter_Id;
	}
	public int getStar_Rating() {
		return star_Rating;
	}
	public void setStar_Rating(int star_Rating) {
		this.star_Rating = star_Rating;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getReview_Date() {
		return review_Date;
	}
	public void setReview_Date(Date review_Date) {
		this.review_Date = review_Date;
	}
	
	
	
}
