package edu.java.contact01;

import java.util.Scanner;

public class Contact {
	private String name;
	private String phone;
	private String email;

	public Contact() {}

	public Contact(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 아래는 Contact 배열을 다루기 위한 static 메서드들

	public static int insert(Contact[] list, int size, Scanner sc) {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력> ");
		String name = sc.next();
		System.out.println("전화번호 입력> ");
		String phone = sc.next();
		System.out.println("이메일 입력> ");
		String email = sc.next();

		list[size] = new Contact(name, phone, email);
		System.out.println("등록된 연락처 개수: " + (size + 1));
		System.out.println("연락처 등록 완료!");
		return size + 1;
	}

	public static void searchAll(Contact[] list, int size) {
		System.out.println("연락처 개수: " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(list[i]);
		}
	}

	public static void searchByIndex(Contact[] list, int size, Scanner sc) {
		System.out.println("검색할 인덱스 입력> ");
		int index = sc.nextInt();
		if (index < 0 || index >= size) {
			System.out.println("잘못된 인덱스입니다.");
			return;
		}
		System.out.println(list[index]);
	}

	public static void edit(Contact[] list, int size, Scanner sc) {
		System.out.println("수정할 인덱스 입력> ");
		int index = sc.nextInt();
		if (index < 0 || index >= size) {
			System.out.println("잘못된 인덱스입니다.");
			return;
		}
		System.out.println("이름 입력> ");
		list[index].setName(sc.next());
		System.out.println("전화번호 입력> ");
		list[index].setPhone(sc.next());
		System.out.println("이메일 입력> ");
		list[index].setEmail(sc.next());

		System.out.println("연락처 수정 완료!");
		System.out.println(list[index]);
	}

	public static int delete(Contact[] list, int size, Scanner sc) {
		System.out.println("삭제할 인덱스 입력> ");
		int index = sc.nextInt();
		if (index < 0 || index >= size) {
			System.out.println("잘못된 인덱스입니다.");
			return size;
		}
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		System.out.println("연락처 삭제 완료!");
		return size - 1;
	}
}