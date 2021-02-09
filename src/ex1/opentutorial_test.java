package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class opentutorial_test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1) jdbc 드라이버를 메모리에 로딩 시킨다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2) DBMS 서버 접속
		// DriverManager 클래스의 getConnection()메서드는 실제 자바 프로그램과
		// 네트워크상의 데이터베이스를 연결해주는 역할을 한다. 연결에 성공을하면 Connection 객체를 반환한다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		
		// 3) STATEMENT
		// 접속에 성공하였으면 자바프로그램에서 SQL문을 전달하고 DB에서는 SQL문의 결과값을 전달하는데
		// 그 역활을 하는것이 STATEMENT객체이다.
		// Connection객체의 creatStatement메서드를 사용한다.
		
		// DB로 SQL문을 요청하기 위해서는 Statement 객체뿐만아니라, PreparedStatement객체도 존재한다.
		// 가독성이 좋기에 PreparedState객체를 많이 사용한다.
		Statement stmt = conn.createStatement();
		ResultSet re = stmt.executeQuery("select * from emp");
		
		while(re.next()) {
			System.out.println(re.getString("job"));
		}
		
		re.close();
		stmt.close();
		conn.close();
	}
}
