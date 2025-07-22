package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {

	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수를 정수로 입력받아서 3개의 변수에 저장.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력: ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력: ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력: ");
		int math = sc.nextInt();
		
		// 2. 메소드를 정의하여 세 과목의 총점을 출력
		int total = calcTotal(kor, eng, math);
		System.out.println("총점: " + total);
		
		// 3. 메소드를 정의하여 세 과목의 평균을 출력(소수점까지)
		double avg = calcAverage(total);
		System.out.println("평균: " + avg);
		
		// 4. 메소드를 정의하여 평균에 따른 등급을 출력
		char grade = calcGrade(avg);
		System.out.println("등급: " + grade);
		
		sc.close();
		
	}

	// 메소드 이름 : calcTotal
	// 기능 : 전달받은 3개의 정수로 총점을 리턴하는 메소드
	public static int calcTotal(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	// 메소드 이름 : calcAverage
	// 기능 : 전달받은 총점으로 평균을 리턴하는 메소드
	public static double calcAverage(double total) {
		return total / 3;
	}
	
	
	// 메소드 이름 : calcGrade
	// 기능 : 평균 점수에 따른 등급(char)을 리턴하는 메소드
	// 100 ~ 90 -> 'A'
	// 89 ~ 80 -> 'B'
	// 79 ~ 70 -> 'C'
	// 70 미만 -> 'F'
	public static char calcGrade(double avg) {
		if (avg >= 90)
			return 'A';
		else if (avg >= 80)
			return 'B';
		else if (avg >= 70)
			return 'C';
		else
			return 'F';
	}
}
