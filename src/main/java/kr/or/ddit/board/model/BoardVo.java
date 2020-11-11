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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNo;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVo other = (BoardVo) obj;
		if (boardNo != other.boardNo)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
