package edu.java.interface06;

//  * DAO(Data Access Object): 
// 데이터의 전송을 담당하는 역할

// * DAO 인터페이스 메소드 설계 방식
// - 메소드의 리턴타입: 돌려주는 데이터 형태에 따라 선언
// - 메소드의 매개변수: 전송되는 데이터 형태에 따라 선언
// - 메소드의 이름: 역할에 따라 이름 작성

public interface MemberDAO {
	// 회원 정보 등록
	public abstract int insert(MemberVO vo);
	
	// 회원 정보 전체 검색
	public abstract MemberVO[] select();
	
	// 회원 정보 인덱스(상세 검색)
	public abstract MemberVO select(int index);
	
	// 회원 정보 인덱스(상세) 수정
	public abstract int update(int index, MemberVO vo);
}
