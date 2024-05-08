package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao {
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> login(List<Object> param) {

		String sql = "SELECT *\n"
				+ "FROM JAVA_MEMBER\n"
				+ "WHERE id = ?\n"
				+ "AND PASS = ?\n"
				+ "AND DELYN = 'N'\n"
				+ "AND ROLE = ?";
		
		return jdbc.selectOne(sql, param);	
	}
	
	
}
