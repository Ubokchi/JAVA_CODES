package edu.java.collection04;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionMain04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 3. ArrayList를 생성하여 학생 정보 3개를 입력받아 list에 저장
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i = 0 ; i < 3; i++) {
			System.out.println("학생 이름 입력>");
			String name = sc.next();
			System.out.println(name + "학생 수학 점수 입력>");
			int math = sc.nextInt();
			System.out.println(name + "학생 영어 점수 입력>");
			int eng = sc.nextInt();
			
			Score score = new Score(math, eng);
			Student student = new Student(name, score);
			list.add(student);
			
		}
		
		// 4. 전체 학생 정보 검색(출력)			
		for(Student n: list) {
			System.out.println(n);
		}
		
		// 5. list에 저장된 index 1번 학생의 데이터 수정
		// 예시) 이름: ~, 수학: 100, 영어: 50
		
		int eng = sc.nextInt();
		list.set(eng, new Student("~", new Score(100, 50)));
		
		// 6. 데이터 삭제: 1번 학생의 데이터 삭제
		list.remove(1);
		
		// 7. 변경된 베이터 확인
		for(Student n: list) {
			System.out.println(n);
		}
	}

}
