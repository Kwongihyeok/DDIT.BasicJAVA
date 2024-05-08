package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FreeDao {
	private static FreeDao instance;

	private FreeDao() {

	}

	public static FreeDao getInstance() {
		if (instance == null) {
			instance = new FreeDao();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> list(){
		String sql = "SELECT NO, NAME , CONTENT\n"
				+ "FROM JAVA_FREEBOARD\n"
				+ "WHERE DELYN = 'N'\n"
				+ "ORDER BY NO\n";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> detail(List<Object> param){
		
		String sql = "SELECT NO, NAME , CONTENT, WRITER , REGDATE \n"
					+ "FROM JAVA_FREEBOARD\n"
					+ "WHERE NO = ?\n";
		return jdbc.selectOne(sql, param);
	}
	
	public void delete(List<Object> param) {
		String sql = "UPDATE JAVA_FREEBOARD SET DELYN  = 'Y' WHERE NO = ?";
		
		jdbc.update(sql,param);
	}

	public void insert(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO JAVA_FREEBOARD(NO, NAME, CONTENT, WRITER)\r\n"
	            + "VALUES((SELECT NVL(MAX(NO),0)+1 FROM JAVA_FREEBOARD),?, ?, ?)";
		
		jdbc.update(sql, param);
	}
}
