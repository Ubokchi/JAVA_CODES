package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	public static final int MENU_QUIT = 0;
	public static final int MENU_INSERT = 1;
	public static final int MENU_SEARCHALL = 2;
	public static final int MENU_SEARCHBYINDEX = 3;
	public static final int MENU_EDIT = 4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contact[] list = new Contact[100];
		int choice = -1;
		int size = 0;
		
		while(choice != MENU_QUIT) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택>");
			choice = sc.nextInt();
			
			switch(choice) {
			case MENU_QUIT:
				choice = MENU_QUIT;
				System.out.println("프로그램 종료");
				break;
			case MENU_INSERT:
				System.out.println("-------------");
				System.out.println("연락처 등록 메뉴");
				System.out.println("-------------");
				System.out.println("이름 입력>");
				String name = sc.next();
				System.out.println("전화번호 입력>");
				String phone = sc.next();
				System.out.println("이메일 입력>");
				String email = sc.next();
				
				list[size] = new Contact(name, phone, email);
				size++;
				
				System.out.println("등록된 연락처 개수: " + size);
				System.out.println("연락처 등록 완료!");
				break;
			case MENU_SEARCHALL:
				System.out.println("연락처 개수: " + size);
				
				for(int i = 0; i < size; i++) {
					System.out.println(list[i].toString());
				}
				break;
			case MENU_SEARCHBYINDEX:
				System.out.println("검색할 인덱스 입력>");
				int search = sc.nextInt();
				
				System.out.println(list[search].toString());
				break;
			case MENU_EDIT:
				System.out.println("수정할 인덱스 입력>");
				int edit = sc.nextInt();
				
				System.out.println("이름 입력>");
				list[edit].setName(sc.next());
				System.out.println("전화번호 입력>");
				list[edit].setPhone(sc.next());
				System.out.println("이메일 입력>");
				list[edit].setEmail(sc.next());
				
				System.out.println("연락처 수정 완료!");
				System.out.println(list[edit].toString());
				break;
			default:
				System.out.println("0~4 중에 선택하세요.");
			}
			
		}

	}

}
