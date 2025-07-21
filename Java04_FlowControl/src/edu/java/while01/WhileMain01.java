package edu.java.while01;

import java.util.Scanner;

// while 문
// - for문과 같은 반복문
// - 선언 형태
//		while(조건) {
//			(본문)
//		}
public class WhileMain01 {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		// 1 ~ 10까지 출력
		int x = 1;
		while(x <= 10) {
			System.out.print(x + " ");
			x++;
		}
		System.out.println();
		
		int d = 2;
		while(d <= 9) {
			System.out.println(d + "단");
			int i = 1;
			while(i <= 9) {
				System.out.println(d + " X " + i + " = " + d * i);
				i++;
			}
			d++;
		}

		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i >= j) {
					System.out.print("*");					
				}
			}
			System.out.println();
		}


	}

}