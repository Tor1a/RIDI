package ridi.model.member;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Repository
public class MemberDto {
	private int no;
	private String name;
	private String RRN; // ÁÖ¹Î¹øÈ£
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
	private Date creation_Date;
}
