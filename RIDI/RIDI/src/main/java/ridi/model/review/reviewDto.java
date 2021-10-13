package ridi.model.review;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class reviewDto {
	private int no;
	private int book_No;
	private String contents;
	private String wirter_Id;
	private int star_Rating;
	private String password;
	private Date review_Date;
	
}
