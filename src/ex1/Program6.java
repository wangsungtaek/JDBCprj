package ex1;

import java.sql.SQLException;

import newlecture.app.entity.Notice1;
import newlecture.app.service.NoticeService1;

public class Program6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeService1 test = new NoticeService1();
		
		test.getList();
//		test.insert(new Notice1("wang_gun","wang","goooooood"));
//		test.delete(33);
		test.update(new Notice1(2,"updatae","wang","success"));
		System.out.println("--------------");
		test.getList();
	}
}
