package ridi.model.orders;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import ridi.model.member.MemberDao;

@Repository
public class OrdersDto {
	private int no;
	private int order_No;
	private String book_Name;
	private int QTY; // ����
	private int price;
	private String ordered;
	private String shipping_Address;
	private String shipping_Stage;
	private Date order_Date;
	private String seller;
	private String payCheck;
	public OrdersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersDto(int no, int order_No, String book_Name, int qTY, int price, String ordered,
			String shipping_Address, String shipping_Stage, Date order_Date, String seller, String payCheck) {
		super();
		this.no = no;
		this.order_No = order_No;
		this.book_Name = book_Name;
		QTY = qTY;
		this.price = price;
		this.ordered = ordered;
		this.shipping_Address = shipping_Address;
		this.shipping_Stage = shipping_Stage;
		this.order_Date = order_Date;
		this.seller = seller;
		this.payCheck = payCheck;
	}
	@Override
	public String toString() {
		return "OrdersDto [no=" + no + ", order_No=" + order_No + ", book_Name=" + book_Name + ", QTY=" + QTY
				+ ", price=" + price + ", ordered=" + ordered + ", shipping_Address=" + shipping_Address
				+ ", shipping_Stage=" + shipping_Stage + ", order_Date=" + order_Date + ", seller=" + seller
				+ ", payCheck=" + payCheck + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrder_No() {
		return order_No;
	}
	public void setOrder_No(int order_No) {
		this.order_No = order_No;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public int getQTY() {
		return QTY;
	}
	public void setQTY(int qTY) {
		QTY = qTY;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrdered() {
		return ordered;
	}
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}
	public String getShipping_Address() {
		return shipping_Address;
	}
	public void setShipping_Address(String shipping_Address) {
		this.shipping_Address = shipping_Address;
	}
	public String getShipping_Stage() {
		return shipping_Stage;
	}
	public void setShipping_Stage(String shipping_Stage) {
		this.shipping_Stage = shipping_Stage;
	}
	public Date getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getPayCheck() {
		return payCheck;
	}
	public void setPayCheck(String payCheck) {
		this.payCheck = payCheck;
	}
	
	
}
