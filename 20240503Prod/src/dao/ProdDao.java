package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ProdDao {
	private static ProdDao instance;

	private ProdDao() {

	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> list() {
		String sql = "SELECT * FROM JAVA_PROD";
		
		return jdbc.selectList(sql);
	}

	public void insert(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO JAVA_PROD\n"
				+ "VALUES((SELECT NVL(MAX(NO), 0)+ 1\n"
				+ "FROM JAVA_PROD), ?, ?, ?, 'N')";
		
		jdbc.update(sql, param);
	}
	public int delete(List<Object> param) {
		String sql = "UPDATE JAVA_PROD\n"
				+ "SET\n"
				+ "DELYN = 'Y'\n"
				+ "WHERE NO = ?";
		return jdbc.update(sql,param);
	}

	public void update(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "UPDATE JAVA_PROD\n"
				+ "SET\n"
				+ "NAME = ?,\n"
				+ "TYPE = ?,\n"
				+ "PRICE  = ?\n"
				+ "WHERE NO = ?";
		
		jdbc.update(sql, param);
	}
}
