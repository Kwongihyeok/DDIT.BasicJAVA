package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

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
	
	public MemberVo login(List<Object> param) {
		String sql ="select * from java_member\r\n" + 
				"where id = ?\r\n" + 
				"and pass = ?\r\n" + 
				"and delyn = 'N'\r\n" + 
				"and role = ?";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	
}
