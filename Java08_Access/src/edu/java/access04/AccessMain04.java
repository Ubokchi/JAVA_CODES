package edu.java.access04;

public class AccessMain04 {

	public static void main(String[] args) {
		// 연락처 정보를 3개 생성하여 배열에 저장하고
		// 출력하는 코드

		// 객체 생성 및 데이터 저장 방식1
		Contact c1 = new Contact(0, "유복치", "010-1111-1111", "you@gmail.com");
		System.out.println(c1.toString());

		System.out.println();
		// 전화번호를 변경
		c1.setPhone("010-2222-2222");
		System.out.println(c1.toString());

		// 객체 생성 및 데이터 저장 방식2
		Contact c2 = new Contact();
		System.out.println(c2.toString());
		c2.setNo(1);
		c2.setName("개복치");
		c2.setPhone("010-3333-3333");
		c2.setEmail("gae@gmail.com");
		System.out.println(c2.toString());

		// 3명의 연락처 정보를 배열로 묶음
		Contact[] contacts = new Contact[3];
		contacts[0] = c1; // 유복치 연락처 정보
		contacts[1] = c2; // 개복치 연락처 정보
		contacts[2] = new Contact(2, "김복치", "010-5555-5555", "kim@gmail.com");
		
		System.out.println("===================");
		
		// 퀴즈) for-each 구문을 사용하여
		// 3명의 데이터 중 개복치의 전화번호만 출력하시오.
		
		for (Contact c: contacts) {
			if (c.getName().equals("개복치")) {
				System.out.println(c.getPhone());
			}
		}
		
	}
}
