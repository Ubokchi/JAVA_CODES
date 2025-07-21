package edu.java.variable09;

import java.util.Scanner;

public class ScannerMain02 {

	public static void main(String[] args) {
		System.out.println("문자 하나 입력");
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 입력받은 문자열 저장
		char ch1 = str.charAt(0); // 문자 하나 저장
		System.out.println("ch1 = " + ch1);
	}

}
