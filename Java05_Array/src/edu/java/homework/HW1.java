package edu.java.homework;

import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		
		// 과제1. 
		for (char i = 'A'; i <= 'Z'; i++ ) {
			System.out.println(i);
		}
		System.out.println();
		
		// 과제 2.
		int dice1, dice2;
		int sum = -1;
		
		while (sum != 5) {
			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;
			sum = dice1 + dice2;
			
			System.out.println("(" + dice1 + ", " + dice2 + ")");
			
		}
		System.out.println();
		
		// 과제3.
		int n = 1;
		sum = 0;
		
		while (true) {
			if (n % 2 == 1)
				sum += n;
			else
				sum -= n;
			
			if (sum >= 100)
				break;
			n += 1;
		}
		
		System.out.println("n = " + n);
		System.out.println("sum = " + sum);
		System.out.println();
		
		// 과제4.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = i; j < 5; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
		
		// 과제5.
		Scanner sc = new Scanner(System.in);
		int num;

		do {
			System.out.print("몇 단을 출력할까요?> ");
			num = sc.nextInt();
			
			if (num >= 2 && num <= 9) {
				for (int i = 1; i <= 9; i++) {
					System.out.println(num + " * " + i + " = " + num * i);
				}
				break;
			}

			System.out.println("2~9단 중에 입력하세요.");
		} while (true);
		System.out.println();
		
		// 과제6.
		int rand = (int)(Math.random() * 100) + 1;
		boolean correct = false;
		
		while (correct == false) {
			System.out.print("숫자를 입력하세요: ");
			num = sc.nextInt();
			
			if (num > rand) {
				System.out.println("너무 큽니다.");
			}
			else if (num < rand) {
				System.out.println("너무 작습니다.");
			}
			else {
				System.out.println("정답입니다.");
			}
		}
		
		sc.close();

	}

}
