package kr.or.ddit.board.model;

public class BoardVo {
	private int boardNo;
	private String title;
	private String content;

	// 프레임워크 입장에서는 인자가 없는 기본생성자가 필요하다.
	// 인자가 있는 생성자를 이용하기 위해서는 별도로 기본생성자를 만들어 주자.
	public BoardVo() {

	}
	
	public BoardVo(int boardNo, String title, String content) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}

}
