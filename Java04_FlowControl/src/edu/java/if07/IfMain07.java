package edu.java.if07;

import java.util.Scanner;

public class IfMain07 {

	public static void main(String[] args) {
		System.out.println("입력된 세 개의 정수 중 최대값 구하기");
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a >= b) {
			if(a >= c) {
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		} else if(b >= c) {
			if(b >= a) {
				System.out.println(b);
			} else {
				System.out.println(a);
			}
		} else if(c >= a) {
			if(c >= b) {
				System.out.println(c);
			} else {
				System.out.println(b);
			}
		}

	}

}