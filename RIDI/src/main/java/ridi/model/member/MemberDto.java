package ridi.model.member;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
public class MemberDto {
	private int no;
	private String name;
	private String RRN;
	private String rrn_First;
	private String rrn_Last;
	private String id; 
	private String password;
	private String email;
	private String gender;
	private int zipcode;
	private String address;
	private String address01;
	private String address02;    
	private String hp;
	private String phoneNumber;
	private String phoneMiddleNumber;
	private String phoneLastNumber;
	private String creation_Date;
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(int no, String name, String rRN, String rrn_first, String rrn_last, String id, String password,
			String email, String gender, int zipcode, String address, String address01, String address02, String hp,
			String phoneNumber, String phoneMiddleNumber, String phoneLastNumber, String creation_Date) {
		super();
		this.no = no;
		this.name = name;
		RRN = rRN;
		this.rrn_First = rrn_first;
		this.rrn_Last = rrn_last;
		this.id = id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.zipcode = zipcode;
		this.address = address;
		this.address01 = address01;
		this.address02 = address02;
		this.hp = hp;
		this.phoneNumber = phoneNumber;
		this.phoneMiddleNumber = phoneMiddleNumber;
		this.phoneLastNumber = phoneLastNumber;
		this.creation_Date = creation_Date;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", name=" + name + ", RRN=" + RRN + ", rrn_first=" + rrn_First + ", rrn_last="
				+ rrn_Last + ", id=" + id + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", zipcode=" + zipcode + ", address=" + address + ", address01=" + address01 + ", address02="
				+ address02 + ", hp=" + hp + ", phoneNumber=" + phoneNumber + ", phoneMiddleNumber=" + phoneMiddleNumber
				+ ", phoneLastNumber=" + phoneLastNumber + ", creation_Date=" + creation_Date + "]";
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRRN() {
		return RRN;
	}
	public void setRRN(String rRN) {
		RRN = rRN;
	}
	public String getRrn_first() {
		return rrn_First;
	}
	public void setRrn_first(String rrn_first) {
		this.rrn_First = rrn_first;
	}
	public String getRrn_last() {
		return rrn_Last;
	}
	public void setRrn_last(String rrn_last) {
		this.rrn_Last = rrn_last;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress01() {
		return address01;
	}
	public void setAddress01(String address01) {
		this.address01 = address01;
	}
	public String getAddress02() {
		return address02;
	}
	public void setAddress02(String address02) {
		this.address02 = address02;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneMiddleNumber() {
		return phoneMiddleNumber;
	}
	public void setPhoneMiddleNumber(String phoneMiddleNumber) {
		this.phoneMiddleNumber = phoneMiddleNumber;
	}
	public String getPhoneLastNumber() {
		return phoneLastNumber;
	}
	public void setPhoneLastNumber(String phoneLastNumber) {
		this.phoneLastNumber = phoneLastNumber;
	}
	public String getCreation_Date() {
		return creation_Date;
	}
	public void setCreation_Date(String creation_Date) {
		this.creation_Date = creation_Date;
	}
	
}
