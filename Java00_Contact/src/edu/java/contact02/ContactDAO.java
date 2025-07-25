package edu.java.contact02;

public interface ContactDAO {
	// 회원 정보 등록
	public abstract int insert(ContactVO vo);

	// 회원 정보 전체 검색
	public abstract ContactVO[] selectAll();

	// 회원 정보 인덱스(상세 검색)
	public abstract ContactVO select(int index);

	// 회원 정보 인덱스(상세) 수정
	public abstract int update(int index, ContactVO vo);
}
