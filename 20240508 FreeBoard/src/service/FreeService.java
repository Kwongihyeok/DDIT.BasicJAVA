package service;

import java.util.List;

import dao.FreeDao;
import vo.FreeVo;

public class FreeService {
	private static FreeService instance;

	private FreeService() {

	}

	public static FreeService getInstance() {
		if (instance == null) {
			instance = new FreeService();
		}
		return instance;
	}

	FreeDao freeDao = FreeDao.getInstance();
	
	public List<FreeVo> member_free_list() {
		return freeDao.member_free_list();
	}

	public FreeVo member_free_Detail(List<Object> param) {
		// TODO Auto-generated method stub
		
		return freeDao.member_free_detail(param);
	}
	
	public void member_free_update(List<Object> param) {
		freeDao.member_free_update(param);
	}
}
