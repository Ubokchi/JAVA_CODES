package edu.java.method04;

import java.util.Scanner;

public class MethodMain04 {

	public static void main(String[] args) {
		System.out.println("배열을 매개변수로 갖는 메소드");
		
		// 변수 선언 -> 메모리 공간 생성 -> 주소값이 존재
		int[] scores = new int[5];
		System.out.println("주소값: " + scores);
		
		inputScores(scores);
		
		printScores(scores);
	}

	private static void inputScores (int[] scores) {
		System.out.println("input scores 주소값 : " + scores);
		Scanner sc = new Scanner (System.in);
		for(int i = 0; i < scores.length; i++) {
			System.out.println("점수: " + i + "번째 입력>");
			scores[i] = sc.nextInt();
		}
		sc.close();
	}
	
	private static void printScores(int[] scores) {
		System.out.println("print scores 주소값 : " + scores);
		for (int x : scores) {
			System.out.println("입력한 점수 : " + x);
		}
		
	}
}