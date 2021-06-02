package dto;

import java.sql.Date;

public class BoardDTO {

	private int bNum;
	private String bId;
	private String bTitle;
	private String bContent;
	private Date bDate;
	private int bHits;
	private String bFile;
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getbHits() {
		return bHits;
	}
	public void setbHits(int bHits) {
		this.bHits = bHits;
	}
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bNum=" + bNum + ", bId=" + bId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bDate="
				+ bDate + ", bHits=" + bHits + ", bFile=" + bFile + "]";
	}
	public BoardDTO(int bNum, String bId, String bTitle, String bContent, Date bDate, int bHits, String bFile) {
		super();
		this.bNum = bNum;
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHits = bHits;
		this.bFile = bFile;
	}
	public BoardDTO() {
		super();
	}
	
	
	
}
