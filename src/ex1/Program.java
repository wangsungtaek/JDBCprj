package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM NOTICE WHERE HIT>10";
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url,"scott", "tiger"); // 연결객체
		Statement st = con.createStatement(); //실행 도구생성
		ResultSet rs = st.executeQuery(sql); // 결과 실행
		
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer_id = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			System.out.printf("id: %d, title: %s, writer_id: %s, content: %s, regdate: %s,"
					+ " hit: %d, files: %s\n", id, title, writer_id, content, regdate, hit, files);
		}
		rs.close();
		st.close();
		con.close();
	}
}
/*
CREATE TABLE NOTICE (
		ID NUMBER,
		TITLE	NVARCHAR2(100),
		WRITER_ID	NVARCHAR2(50),
		CONTENT	CLOB,
		REGDATE TIMESTAMP,
		HIT	NUMBER,
		FILES	NVARCHAR2(1000)
	);
*/