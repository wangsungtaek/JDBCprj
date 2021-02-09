package newlecture.app.entity;

import java.util.Date;

public class Notice1 {
	private int id;
	private String title;
	private String writer_id;
	private String content;
	private Date regdate;
	private int hit;
	private String files;
	
	public Notice1() {
	
	}
	public Notice1(String title, String writer_id, String content) {
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
	}
	public Notice1(int id, String title, String writer_id, String content) {
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
	}
	public Notice1(int id, String title, String writer_id, String content, Date regdate, int hit, String files) {
		super();
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
}
