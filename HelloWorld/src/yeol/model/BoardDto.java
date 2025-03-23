package yeol.model;

import java.util.Date;

public class BoardDto {
	private int postCode;
	private String title;
	private String content;
	private String loginId;
	private Date writeDate;
	private int views;

	public BoardDto() {
	}

	public BoardDto(int postCode, String title, String content, String loginId, Date writeDate, int views) {
		this.postCode = postCode;
		this.title = title;
		this.content = content;
		this.loginId = loginId;
		this.writeDate = writeDate;
		this.views = views;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getTitle() {
		return title;
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

	public int getViews() {
		return views;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setViews(int views) {
		this.views = views;
	}

}
