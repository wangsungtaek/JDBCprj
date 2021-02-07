package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST3";
		String content = "aaaa";
		String files = "";
		int id = 5;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE1 WHERE id = ?";
				   
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 	// jdbc driver load (메모리에 잡히게됨)
		Connection con = DriverManager.getConnection(url,"scott", "tiger"); // 연결객체
		//Statement st = con.createStatement(); //실행 도구생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
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