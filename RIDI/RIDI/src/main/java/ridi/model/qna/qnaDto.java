package ridi.model.qna;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class qnaDto {
	private int no;
	private String content;
	private int book_No;
	private String writer_Id;
	private String reply_Ok;
}
