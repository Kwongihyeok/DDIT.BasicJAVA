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
		String sql ="select * from java_member\r\n" + 
				"where id = ?\r\n" + 
				"and pass = ?\r\n" + 
				"and delyn = 'N'\r\n" + 
				"and role = ?";
		return jdbc.selectOne(sql, param);
	}
	
	
}
