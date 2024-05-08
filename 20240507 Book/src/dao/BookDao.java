package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BookDao {
	private static BookDao instance;

	private BookDao() {

	}

	public static BookDao getInstance() {
		if (instance == null) {
			instance = new BookDao();
		}
		return instance;

	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> bookList(){
		String sql = "select BOOK_NO,TITLE,CONTENT,to_char(PUBDATE,'YYYY.MM.DD')as PUBDATE\r\n" + 
				"from java_book";
		
		return jdbc.selectList(sql);
		
	}

	public void bookUpdate(List<Object> param, int sel) {
		// TODO Auto-generated method stub
		String sql = "UPDATE BOOK SET ";
		
		if(sel == 1 || sel ==3 ) {
			sql += " TITLE = ? ";	
			if(sel == 3) sql+= " , ";
		}
		if(sel == 2 || sel ==3 ) {
			sql += " CONTENT = ? ";
		}
		sql += " WHERE BOOK_NO = ?";
				
		
	}
	
	public List<Map<String, Object>> holdList(List<Object> param){
		String sql = "SELECT *\r\n"
				+ "FROM(SELECT ROWNUM rn, b.*, h.HOLD_no\r\n"
				+ "FROM JAVA_BOOK b, JAVA_BOOK_HOLD h\r\n"
				+ "WHERE b.book_no = h.Book_no\r\n"
				+ "ORDER BY b.book_no)\r\n"
				+ "WHERE(rn >= ?\r\n"
				+ "	AND rn <= ?)";
		return jdbc.selectList(sql,param);
	}
	
	
}
