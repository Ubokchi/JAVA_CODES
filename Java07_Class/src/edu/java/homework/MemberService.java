package edu.java.homework;

public class MemberService {
	boolean isLogin;
	
//	1) 기본 생성자 생성하기
	public MemberService() {}
	
//	2) login 메소드 생성하기(MemberServiceMain.java 클래스의 호출 결과를 보고 구조 유추)
	public boolean login(String id, String pw) {
		if(isLogin == true) {
			return true;
		} else {
			// id, pw 주소값이 전송됨
			// id == "test" : 주소값 비교
			// id.equals("test"): 실제 데이터 비교
			if(id.equals("test") && pw.equals("1234")) {
				isLogin = true;
				return true;
			} else {
				return false;
			}
		}
	}
//	3) logout 메소드 생성하기(MemberServiceMain.java 클래스의 호출 결과를 보고 구조 유추)
	public void logout(String id) {
		if (isLogin == true) {
			isLogin = false;
			System.out.println(id + "님이 로그아웃 되었습니다.");
		}
		return;
	}
}
