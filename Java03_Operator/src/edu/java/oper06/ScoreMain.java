package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {
	
	public static void main(String[] args) {
		System.out.println("총점 및 평균 계산 프로그램");
		
		// 1. 입력받을 준비 : Scanner 변수 생성
		Scanner sc = new Scanner(System.in);
		
		// 2. 국어, 영어, 수학 점수를 정수로 입력받아서 3개의 변수에 각각 저장
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt();
		
		// 3. 국어, 영어, 수학 점수를 출력
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		
		// 4. 총점을 계산하여 출력
		System.out.println("총점 : " + (kor + eng + math));
		
		// 5. 평균을 계산하여 출력 (소수점 셋째 자리까지)
		double avg = (double)(kor + eng + math) / 3;
		System.out.printf("평균 : %.3f\n", avg);
	}
}
