package newlecture.app.console;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import newlecture.app.entity.Notice;
import newlecture.app.service.NoticeService;

public class NoticeConsole {
	
	private NoticeService service;
	private int page;
	private String searchField = "TITLE";
	private String searchWord = "";
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
	}
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int count = service.getCount();
		int lastPage = count/10;
		lastPage =  count%10 > 0 ? lastPage+1 : lastPage;
		
		System.out.println("---------------------------------------");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("---------------------------------------");
		
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n",
							n.getId(),
							n.getTitle(),
							n.getWriter_id(),
							n.getRegdate());
		}
		System.out.println("---------------------------------------");
		System.out.printf("            %d/%d pages\n", page,lastPage);
	}
	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.검색/ 6.종료 >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		
		return menu;
	}

	public void movePrevList() {
		if(page == 1) {
			System.out.println("-------------------------");
			System.out.println("이전 페이지가 없습니다.");
			System.out.println("-------------------------");
			return;
		}
		page--;
	}
	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/10;
		lastPage =  count%10 > 0 ? lastPage+1 : lastPage;
		
		if(page == lastPage) {
			System.out.println("-------------------------");
			System.out.println("이후 페이지가 없습니다.");
			System.out.println("-------------------------");
			return;
		}
		page++;
	}

	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주(title/content/writerId)중에 하나를 입력하세요");
		System.out.println(" > ");
		searchField = scan.nextLine();
		
		System.out.println(" 검색어 > ");
		searchWord = scan.nextLine();
	}
}
