package util;

public enum View {
	
	HOME,							// 홈	
	MEMBER,							// 회원
	ADMIN,							// 관리자
	MEMBER_LOGIN,					// 회원 로그인
	
	//ADMIN
	ADMIN_FREEBOARD_LIST,			// 전체 게시판
	ADMIN_FREEBOARD_MANAGEMENT,		// 게시판 관리
	ADMIN_FREEBOARD_DETAIL,			// 게시판 상세 조회
	ADMIN_FREEBOARD_FAULTY,			// 불량 게시판 조회
	
	//MEMBER
	MEMBER_FREEBOARD_LIST,			// 전체 게시판
	MEMBER_FREEBOARD_DETAIL,		// 게시판 상세 조회
	MEMBER_FREEBOARD_UPDATE,		// 게시판 변경
	MEMBER_FREEBOARD_DELETE,		// 게시판 삭제
	MEMBER_FREEBOARD_ADD			// 게시판 등록

}
