package edu.java.for04;

public class ForMain04 {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1. 1 ~ 10까지 숫자 중
		// 홀수일 경우 "홀수"가 출력되고
		// 짝수일 경우 "짝수"가 출력되도록 구현
		// 예시) 홀수 짝수 홀수 짝수 ...
		for(int x = 1; x <= 10; x++) {
			if(x % 2 == 0) {
				System.out.print("짝수 ");
			} else {
				System.out.print("홀수 ");
			}
		}
		System.out.println();
		
		// 2. 아래와 같은 출력 결과를 for문과 if문을 활용하여 구현
		// 1꼬마 2꼬마 3꼬마 인디언
		// 4꼬마 5꼬마 6꼬마 인디언
		// 7꼬마 8꼬마 9꼬마 인디언
		// 10꼬마 인디언 보이~
		
		for(int x = 1; x <= 10; x++) {
			System.out.print(x + "꼬마 ");
			if(x % 3 == 0) {
				System.out.println("인디언");
			}
		}
		System.out.println("인디언 보이~");

	}

}