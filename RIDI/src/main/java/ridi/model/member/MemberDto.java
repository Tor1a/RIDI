package ridi.model.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
	private int no;
	private String name;
	private String RRN; // �ֹι�ȣ
	private String id;
	private String password;
	private String email;
	private String gender;
	private int zipcode;
	private String address;
	private String hp;
	private Date creation_Date;
}
