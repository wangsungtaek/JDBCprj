package newlecture.app.service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import newlecture.app.entity.Notice1;

public class NoticeService1 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upass = "tiger";
	
	public void getList() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		String sql = "SELECT * FROM NOTICE1";
		Connection conn = DriverManager.getConnection(url, uid, upass);
		PreparedStatement stmd = conn.prepareStatement(sql);
		
		ResultSet re = stmd.executeQuery();
		
		while(re.next()) {
			System.out.print(re.getInt("id")+"\t");
			System.out.print(re.getString("title")+"\t");
			System.out.print(re.getString("writer_id")+"\t");
			System.out.print(re.getString("content")+"\t");
			System.out.print(re.getInt("hit")+"\t");
			System.out.print(re.getString("files")+"\n");
		}
		
		re.close();
		stmd.close();
		conn.close();
	}

	public void insert(Notice1 notice) throws ClassNotFoundException, SQLException {
		int id = notice.getId();
		String title = notice.getTitle();
		String writer_id = notice.getWriter_id();
		String content = notice.getContent();
		Date regdate = notice.getRegdate();
		int hit = notice.getHit();
		String files = notice.getFiles();
		
		
		String sql = "INSERT INTO NOTICE1(id, title, writer_id, content, files) "
				   + "VALUES(NOTICE_SEQ.NEXTVAL,?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,uid,upass);
		PreparedStatement stmd = conn.prepareStatement(sql);
		stmd.setString(1, title);
		stmd.setString(2, writer_id);
		stmd.setString(3, content);
		stmd.setString(4, files);
		
		int a = stmd.executeUpdate();
		System.out.println(a);
		
		stmd.close();
		conn.close();
	}

	public void update(Notice1 notice) throws ClassNotFoundException, SQLException {
		int id = notice.getId();
		String title = notice.getTitle();
		String files = notice.getFiles();
		String content = notice.getContent();
		
		String sql = "UPDATE NOTICE1 SET title=?, files=?, content=? WHERE id=?";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,uid,upass);
		PreparedStatement prst = conn.prepareStatement(sql);
		prst.setString(1, title);
		prst.setString(2, files);
		prst.setString(3, content);
		prst.setInt(4, id);
		
		prst.executeUpdate();
		
		prst.close();
		conn.close();
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "DELETE FROM NOTICE1 WHERE id=? ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,uid,upass);
		PreparedStatement prst = conn.prepareStatement(sql);
		prst.setInt(1, id);
		int a = prst.executeUpdate();
		System.out.println(a);
		
		prst.close();
		conn.close();
	}
}
