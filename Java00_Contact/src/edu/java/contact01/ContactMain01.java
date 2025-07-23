package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	public static final int MENU_QUIT = 0; // 종료
	public static final int MENU_INSERT = 1; // 등록
	public static final int MENU_SELECT_ALL = 2; // 전체 검색
	public static final int MENU_SELECT = 3; // 상세 검색
	public static final int MENU_UPDATE = 4; // 수정

	public static final int MAX = 100; // 연락처 최대 저장 개수

	// 연락처 저장 배열
	public static Contact[] contactList = new Contact[MAX];
	public static int count = 0; // 배열에 데이터를 저장하면 증가하는 count
	// 현재 연락처 배열에 저장된 연락처 개수를 알 수 있음
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("연락처 프로그램 version 0.1");

		boolean run = true;

		while(run) {
			showMainMenu();
			int choice = sc.nextInt();

			switch(choice) {
			case MENU_INSERT: //등록
				insertContact();
				break;
			case MENU_SELECT_ALL: // 전체 검색
				selectAllContact();
				break;
			case MENU_UPDATE: // 수정
				updateContact();
				break;
			case MENU_SELECT:
				selectContact();
				break;
			case MENU_QUIT: //종료
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 번호 선택입니다.");
				break;
			}
		}

	} // end main()

	private static void insertContact() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력> ");
		String name = sc.next();
		System.out.println("전화번호 입력> ");
		String phone = sc.next();
		System.out.println("이메일 입력> ");
		String email = sc.next();
		
		Contact c = new Contact(name, phone, email);
		
		// 배열에 저장(인덱스 0부터 순서대로)
		contactList[count] = c; // count 번에 데이터 저장
		count++; // 등록이 수행될 때마다 1씩 증가
		System.out.println("등록된 연락처 개수: " + count);
		System.out.println("연락처 등록 완료!");
	}

	private static void selectAllContact() {
		System.out.println("연락처 개수: " + count);
		for (int i = 0; i < count; i++) {
			System.out.println("--- 연락처 " + i + " ---");
			System.out.println(contactList[i].toString());
		}
		
	}
	
	private static void selectContact() {
		System.out.println("---------------");
		System.out.println("검색할 인덱스 입력> ");
		int index = sc.nextInt();
		
		if (index >= 0 || index < count) {
			System.out.println(contactList[index].toString());	
			return;
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	}

	private static void updateContact() {
		System.out.println("---------------");
		System.out.println("수정할 인덱스 입력> ");
		int index = sc.nextInt();
		
		if (index >= 0 && index < count) {
			System.out.println("이름 입력> ");
			String name = sc.next();
			System.out.println("전화번호 입력> ");
			String phone = sc.next();
			System.out.println("이메일 입력> ");
			String email = sc.next();
			
			contactList[index].setName(name);
			contactList[index].setPhone(phone);
			contactList[index].setEmail(email);

			System.out.println("연락처 수정 완료!");
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	}

	private static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");
	} // end showMainMenu()

}








