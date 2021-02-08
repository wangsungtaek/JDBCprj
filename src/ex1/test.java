package ex1;

import java.sql.SQLException;

import newlecture.app.entity.Notice;
import newlecture.app.service.NoticeService;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		NoticeService service = new NoticeService();
		
		for(int i=0; i<30; i++) {
			service.insert(new Notice("test"+i, "a"+i, "content"+i));
			Thread.sleep(500);
		}
	}
}
