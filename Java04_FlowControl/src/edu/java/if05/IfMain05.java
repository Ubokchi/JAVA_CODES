package edu.java.if05;

import java.util.Scanner;

public class IfMain05 {

	public static void main(String[] args) {
		// 퀴즈) 문자 하나를 입력받아서 그 글자가
		// 1) A ~ Z이면, "영대문자" 출력
		// 2) a ~ z이면, "영소문자" 출력
		// 3) 그 외 경우는, "몰라요" 출력
		
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		
		if('A' <= ch && ch <= 'Z') {
			System.out.println("영대문자");
		} else if('a' <= ch && ch <= 'z') {
			System.out.println("영소문자");
		} else {
			System.out.println("몰라요");
		}

	}

}