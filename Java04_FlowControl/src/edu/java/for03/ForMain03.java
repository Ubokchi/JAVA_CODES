package edu.java.for03;

public class ForMain03 {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		// 1. 1 ~ 100까지 정수 중에서 10의 배수들만 출력
		for(int x = 1; x <= 100; x++) {
			if(x % 10 == 0) {
				System.out.print(x + " ");				
			}
		}
		
		System.out.println();
		
		// 2. 다음과 같이 숫자를 출력
//		1 2 3 4 5 6 7 8 9 10 
//		11 12 13 14 15 16 17 18 19 20 
//		21 22 23 24 25 26 27 28 29 30 
//		31 32 33 34 35 36 37 38 39 40 
//		41 42 43 44 45 46 47 48 49 50 
//		51 52 53 54 55 56 57 58 59 60 
//		61 62 63 64 65 66 67 68 69 70 
//		71 72 73 74 75 76 77 78 79 80 
//		81 82 83 84 85 86 87 88 89 90 
//		91 92 93 94 95 96 97 98 99 100 
		
		for(int x = 1; x <= 100; x++) {
			System.out.print(x + " ");
			if(x % 10 == 0) {
				System.out.println();
			}
		}

	}

}