package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import service.ProdService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {
	
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memberService = MemberService.getInstance();
	ProdService prodService = ProdService.getInstance();
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case LOGIN:
				view = login();
				break;
			case ADMIN:
				view = admin();
				break;
			case MEMBER:
				view = member();
				break;
			case ADMIM_PROD_INSERT:
				view = admin_prod_insert();
				break;
			case ADMIM_PROD_DELETE:
				view = admin_prod_delete();
				break;
			case ADMIM_PROD_UPDATE:
				view = admin_prod_update();
				break;
			case ADMIM_PROD_LIST:
				view = admin_prod_list();
				break;
			case ADMIM_PROD_DETAIL:
				view = admin_prod_detail();
				break;
			default:
				break;
			}
		}
	}

	
	private View home() {
		System.out.println("1. 관리자");
		System.out.println("2. 일반 회원");
		
		int sel = ScanUtil.menu();
		if (sel == 1) return View.ADMIN;
		else if (sel == 2) return View.MEMBER;
		else return View.HOME;
	}
	
	private View login() {
		
		String id = ScanUtil.nextLine("ID >>");
		String pw = ScanUtil.nextLine("PW >>");
		int role = (int) sessionStorage.get("role");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		param.add(role);
		
		
		boolean loginchk = memberService.login(param, role);
		if (!loginchk) {
			System.out.println("로그인 실패");
			return View.LOGIN;
		}
		if (role == 1) {
			return View.MEMBER;
		}
		else{
			return View.ADMIN;			
		}

	}
	
	private View admin() {
		
		if (!sessionStorage.containsKey("admin")) {
			sessionStorage.put("role", 2);
			return View.LOGIN;
		}
		
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 삭제");
		System.out.println("3. 상품 변경");
		System.out.println("4. 상품 전체 출력");
		System.out.println("5. 로그아웃");
		
		int sel = ScanUtil.menu();
		if (sel == 1) {
			return View.ADMIM_PROD_INSERT; 
		}else if (sel == 2) {
			return View.ADMIM_PROD_DELETE; 
		}else if (sel == 3) {
			return View.ADMIM_PROD_UPDATE; 
		}else if (sel == 4) {
			return View.ADMIM_PROD_LIST; 
		}else if (sel == 5) {
			sessionStorage.remove("admin");
			return View.HOME;
		}else {
			return View.ADMIN;
		}
	}
	
	private View member() {
		System.out.println("회원");
		return View.HOME;
	}
	private View admin_prod_list() {
		List<Map<String, Object>> list = prodService.list();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		
		System.out.println("1. 다음페이지");
		System.out.println("2. 이전페이지");
		System.out.println("3. 홈(관리자)");
		
		int sel = ScanUtil.menu();
		if(sel == 1) {
			return View.ADMIM_PROD_LIST;
		}else if(sel == 2) {
			return View.ADMIM_PROD_LIST;
		}else if(sel == 3) {
			return View.ADMIN;
		}else {
			return View.PROD_LIST;
		}
	}
	
	private View admin_prod_detail() {
		return null;
	}
	
	private View admin_prod_insert() {
		System.out.println("상품 추가");
		List<Object> param = new ArrayList<Object>();
		String name = ScanUtil.nextLine("상품명 >>");
		String type = ScanUtil.nextLine("타입 >>");
		int price = ScanUtil.nextInt("가격 >> ");
		
		param.add(name);
		param.add(type);
		param.add(price);
		
		prodService.insert(param);
		
		return View.ADMIM_PROD_LIST;
	}
	private View admin_prod_delete() {
		List<Map<String, Object>> list = prodService.list();
		System.out.println("-------------상품 삭제-------------");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		int prodno = ScanUtil.nextInt("상품 번호 >>");
		List<Object> param = new ArrayList<Object>();
		param.add(prodno);
		
		int result = prodService.delete(param);
		
		if(result == 0) {
			System.out.println("삭제에 실패했습니다.");
			return View.ADMIM_PROD_DELETE;
		}
		return View.ADMIM_PROD_LIST;
		
		
		
	}
	private View admin_prod_update() {
		System.out.println("-------------상품 변경-------------");
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		int prodno = ScanUtil.nextInt("상품 번호 >>");
		String name = ScanUtil.nextLine("상품명 >>");
		String type = ScanUtil.nextLine("타입 >>");
		int price = ScanUtil.nextInt("가격 >>");
		
		List<Object> param = new ArrayList();
		param.add(name);
		param.add(type);
		param.add(price);
		param.add(prodno);
		
		prodService.update(param);
		
		return View.ADMIM_PROD_LIST;
	}
	
	
}
