package yeol.model;

import java.util.Date;

public class CommentDto {
	private int commentCode;
	private int postCode;
	private String content;
	private String loginId;
	private Date writeDate;

	public CommentDto() {
	}

	public CommentDto(int commentCode, int postCode, String content, String loginId, Date writeDate) {
		super();
		this.commentCode = commentCode;
		this.postCode = postCode;
		this.content = content;
		this.loginId = loginId;
		this.writeDate = writeDate;
	}

	public int getCommentCode() {
		return commentCode;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getContent() {
		return content;
	}

	public String getLoginId() {
		return loginId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

}
