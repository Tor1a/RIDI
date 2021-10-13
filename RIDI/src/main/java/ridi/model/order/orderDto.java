package ridi.model.orders;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ordersDto {
	private int no;
	private int order_No;
	private String book_Name;
	private int QTY; // ¼ö·®
	private int price;
	private String ordered;
	private String shipping_Address;
	private String shipping_Stage;
	private Date order_Date;
	private String seller;
	private String payCheck;
}
