package ridi.model.book;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class bookDto {
	private int no;
	private String book_Name;
	private int price;
	private int stock;
	private int star_Rating;
	private Date estimated_Time;
	private int shipping_Price;
	private String category;
	private Date publicataion_Date;
	private int pages;
	private String author;
	private String book_Intro;
	private String book_Image;
}
