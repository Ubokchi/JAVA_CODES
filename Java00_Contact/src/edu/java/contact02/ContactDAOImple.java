package edu.java.contact02;

public class ContactDAOImple implements ContactDAO{
	
	// 싱글톤 디자인 패턴 적용
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() {}
	
	// 3. public static 메소드
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	} 
	
	private final int MAX = 100; 
	private ContactVO[] list = new ContactVO[MAX]; 
	private int size;

	public int getSize() {
		return size;
	}
	
	@Override
	public int insert(ContactVO vo) {
		list[size] = vo;
		size++;
		return 1; // 0 : 실패, 1 : 성공
	}

	@Override
	public ContactVO[] select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		return 1;
	}

}




