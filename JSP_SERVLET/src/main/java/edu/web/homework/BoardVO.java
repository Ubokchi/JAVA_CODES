package edu.web.homework;

import java.util.Date;

public class BoardVO {
	private int boardId;
	private String boardTitle;
	private String userid;
	private Date regDate;
	
	public BoardVO() {}
	
	public BoardVO(int boardId, String boardTitle, String userid, Date boardRegDate) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.userid = userid;
		this.regDate = boardRegDate;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", userid=" + userid + ", boardRegDate="
				+ regDate + "]";
	}
}
