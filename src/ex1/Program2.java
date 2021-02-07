package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO NOTICE (TITLE, WRITER_ID, CONTENT, FILES)"
					+ "VALUES(?,?,?,?)";
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url,"scott", "tiger"); // 연결객체
		//Statement st = con.createStatement(); //실행 도구생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		System.out.println(result);
	
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