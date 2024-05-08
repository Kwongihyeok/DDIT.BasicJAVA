package dao;

import java.util.List;

import util.JDBCUtil;
import vo.FreeVo;

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
	
	public List<FreeVo> member_free_list() {
		String sql = "SELECT NO, F.NAME, CONTENT, TO_CHAR(REGDATE, 'YYYYMMDD') REGDATE , F.MEM_NO, M.NAME writer\n"
				+ "FROM JAVA_FREEBOARD F, JAVA_MEMBER M\n"
				+ "WHERE F.MEM_NO = M.MEM_NO\n"
				+ "AND F.DELYN = 'N'\n"
				+ "AND BAN = 'N'";
		
		return jdbc.selectList(sql,FreeVo.class);
	}

	public FreeVo member_free_detail(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "SELECT *\n"
				+ "FROM(SELECT NO, F.NAME, CONTENT, TO_CHAR(REGDATE, 'YYYYMMDD') REGDATE , F.MEM_NO, M.NAME writer, LAG(NO) OVER(ORDER BY NO) PREVNO, LEAD(NO) OVER(ORDER BY NO) NEXTNO\n"
				+ "FROM JAVA_FREEBOARD F, JAVA_MEMBER M\n"
				+ "WHERE F.MEM_NO = M.MEM_NO\n"
				+ "AND F.DELYN = 'N'\n"
				+ "AND BAN = 'N')\n"
				+ "WHERE NO = ?";
		
		return jdbc.selectOne(sql, param, FreeVo.class);
		
	}

	public void member_free_update(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "UPDATE JAVA_FREEBOARD\n"
				+ "SET\n"
				+ "content = ?\n"
				+ "WHERE NO = ?";
		jdbc.update(sql, param);
	}
}
