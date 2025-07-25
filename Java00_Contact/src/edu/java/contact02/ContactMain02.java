package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02 {
	private static Scanner sc;
	private static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("연락처 프로그램 version 0.2");
		sc = new Scanner(System.in);
		dao = ContactDAOImple.getInstance();	// 다형성. 싱글톤 인스턴스 생성

		boolean run = true;
		while(run) {
			showMainMenu();
			int choice = sc.nextInt();

			switch(choice) {
			case Menu.MENU_INSERT:
				insertMember();
				break;
			case Menu.MENU_SELECT_ALL:
				selectAll();
				break;
			case Menu.MENU_SELECT:
				selectByIndex();
				break;
			case Menu.MENU_UPDATE:
				updateMember();
				break;
			case Menu.MENU_QUIT:
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default:
				System.out.println("잘못된 번호 선택입니다");
				break;
			}
		}

	}

	private static void showMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("선택>");

	}

	private static void insertMember() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력> ");
		String name = sc.next();
		System.out.println("전화번호 입력> ");
		String phone = sc.next();
		System.out.println("이메일 입력> ");
		String email = sc.next();

		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.insert(vo);
		if (result == 1) {
			System.out.println("회원 정보 등록 완료");
		}
	}

	private static void selectAll() {
		ContactVO[] list = dao.selectAll();
		System.out.println("등록된 연락처 개수: " + ContactDAOImple.count);
		for (int i = 0; i < ContactDAOImple.count; i++) {
			System.out.println("--- 연락처 " + (i + 1) + " ---");
			System.out.println(list[i]);
		}
	}

	private static void selectByIndex() {
		System.out.println("---------------");
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();

		ContactVO vo = dao.select(index);
		if (index >= 0 && index < ContactDAOImple.count) {
			System.out.println("--- 연락처 " + index + " ---");
			System.out.println(vo);
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	}

	private static void updateMember() {
		
		System.out.println("---------------");
		System.out.println("수정할 인덱스 입력> ");
		int index = sc.nextInt();
		
		if (index >= 0 && index < ContactDAOImple.count) {
			System.out.print("이름 입력> ");
			String name = sc.next();
			System.out.print("전화번호 입력> ");
			String phone = sc.next();
			System.out.print("이메일 입력> ");
			String email = sc.next();

			ContactVO vo = new ContactVO(name, phone, email);
			int result = dao.update(index, vo);
			if (result == 1) {
				System.out.println("연락처 수정 완료!");
			}
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}

		
	}

}
