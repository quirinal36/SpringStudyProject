package you.bacoder.kr.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Board{
	private String search;
	
	private int id;
	private String title;		// 제목
	private String content;
	private Date wdate;
	private int writer;
	private String username;
	private int pageNum;
	private int from;
	private int to;
	private int total;
	private String photoUrl;
	
	public Board() {
	}
	
	public Board(int id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public int getWriter() {
		return this.writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.from=10*(pageNum-1);
		this.to=(pageNum*10);
		if(this.to> total){
			this.to=total;
		}
	}
	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		
	}
	
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
