package edu.java.contact03;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactMain03 {
	private static Scanner sc;
	private static ContactDAO dao;  
	public static void main(String[] args) {
		System.out.println("연락처 관리 프로그램");
		sc = new Scanner(System.in);
		dao = ContactDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성
		
		boolean run = true;
		while(run) {
			showMainMenu();
			int choice = sc.nextInt();
			
			switch(choice) {
			case Menu.INSERT: 
				insertContact();
				break;
			case Menu.SELECT_ALL:
				selectAll();
				break;
			case Menu.SELECT_BY_INDEX:
				selectByIndex();
				break;
			case Menu.UPDATE:
				updateContact();
				break;
			case Menu.DELETE:
				deleteContact();
				break;
			case Menu.QUIT:
				run = false;
				break;
			default:
				System.out.println("다시 선택하세요.");
				break;
			}
		}
	}

	private static void showMainMenu() {
		System.out.println("----------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정  | 5. 삭제 | 0. 종료");
		System.out.println("----------------------------------------------------------");
		System.out.println("선택>");
	}

	private static void insertContact() {
		System.out.println("--- 연락처 정보 등록 ---");
		System.out.println("이름 입력>");
		String name = sc.next();
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();
		
		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.insert(vo);
		if(result == 1) {
			System.out.println("연락처 정보 등록 완료");
		}
		
	}

	private static void selectAll() {
	    ArrayList<ContactVO> list = dao.select();

	    for (int i = 0; i < list.size(); i++) {
	        System.out.println("연락처 정보 [" + i + "]");
	        System.out.println(list.get(i));
	    }
	}
	private static void selectByIndex() {
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple)dao).getSize();
		
		if (index >= 0 && index < size ) {
			ContactVO vo = dao.select(index);
			System.out.println(vo);
		} else {
			System.out.println("헤당 인덱스에 연락처가 없습니다.");
		}
		
		
	}

	private static void updateContact() {
		System.out.println("연락처 정보 수정");
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple)dao).getSize();
		
		if (index >= 0 && index < size) {
			System.out.println("이름 입력>");
			String name = sc.next();
			System.out.println("비밀번호 입력>");
			String phone = sc.next();
			System.out.println("이메일 입력>");
			String email = sc.next();
			
			ContactVO vo = new ContactVO(name, phone, email);
			
			int result = dao.update(index, vo);
			if(result == 1) {
				System.out.println("연락처 정보 수정 완료");
			}
		} else {
			System.out.println("인덱스에 연락처가 없습니다.");
		}
	}
	
	private static void deleteContact() {
		System.out.println("연락처 정보 삭제");
		System.out.println("인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple)dao).getSize();
		
		if (index >= 0 && index < size) {
			
			
			int result = dao.delete(index);
			if(result == 1) {
				System.out.println("연락처 정보 삭제 완료");
			}
		} else {
			System.out.println("인덱스에 연락처가 없습니다.");
		}
		
	}

}






