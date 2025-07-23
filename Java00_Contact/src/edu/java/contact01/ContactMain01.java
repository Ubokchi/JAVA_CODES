package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	public static final int MENU_QUIT = 0;
	public static final int MENU_INSERT = 1;
	public static final int MENU_SEARCHALL = 2;
	public static final int MENU_SEARCHBYINDEX = 3;
	public static final int MENU_EDIT = 4;
	public static final int MENU_DELETE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contact[] list = new Contact[100];
		int choice = -1;
		int size = 0;

		while(choice != MENU_QUIT) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
			System.out.println("--------------------------------------------------------");
			System.out.println("선택>");
			choice = sc.nextInt();

			switch (choice) {
			case MENU_QUIT:
				System.out.println("프로그램 종료");
				break;
			case MENU_INSERT:
				size = Contact.insert(list, size, sc);
				break;
			case MENU_SEARCHALL:
				Contact.searchAll(list, size);
				break;
			case MENU_SEARCHBYINDEX:
				Contact.searchByIndex(list, size, sc);
				break;
			case MENU_EDIT:
				Contact.edit(list, size, sc);
				break;
			case MENU_DELETE:
				size = Contact.delete(list, size, sc);
				break;
			default:
				System.out.println("0~5 중에 선택하세요.");
			}

		}
	}
}
