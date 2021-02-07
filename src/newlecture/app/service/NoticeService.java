package newlecture.app.service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String pwd = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";
			
	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		
		
		String sql = "SELECT * FROM NOTICE1 ORDER BY ID";
		
	
		Class.forName(driver); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결객체
		Statement st = con.createStatement(); //실행 도구생성
		ResultSet rs = st.executeQuery(sql); // 결과 실행
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			Notice notice = new Notice(
								id,
								title,
								writer_id,
								regdate,
								content,
								hit,
								files
							);	
			
			list.add(notice);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String writerId = notice.getWriter_id();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO NOTICE1 (ID, TITLE, WRITER_ID, CONTENT, FILES)"
					+ "VALUES(NOTICE_SEQ.NEXTVAL,?,?,?,?)";
		
	
		Class.forName(driver); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결객체
		//Statement st = con.createStatement(); //실행 도구생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();

		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE NOTICE1"
				   + " SET title = ?,"
				   + "	   content = ?,"
				   + "	   FILES  = ?"
				   + " WHERE id = ?";
		
	
		Class.forName(driver); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결객체
		//Statement st = con.createStatement(); //실행 도구생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE1 WHERE id = ?";
				   
		
	
		Class.forName(driver); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결객체
		//Statement st = con.createStatement(); //실행 도구생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
}