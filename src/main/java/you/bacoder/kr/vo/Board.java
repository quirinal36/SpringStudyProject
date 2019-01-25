package you.bacoder.kr.vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Board extends Content{
	private String content;
	private Date wdate;
	
	public Board() {
	}
	
	public Board(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return wdate;
	}
	public void setDate(Date date) {
		this.wdate = date;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	public static Board parseBoard(ResultSet rs) throws SQLException {
		Board result = new Board();
		result.setId(rs.getInt("id"));
		result.setTitle(rs.getString("title"));
		result.setContent(rs.getString("content"));
		result.setWriter(rs.getString("writer"));
		result.setDate(rs.getDate("wdate"));
		return result;
	}
}
