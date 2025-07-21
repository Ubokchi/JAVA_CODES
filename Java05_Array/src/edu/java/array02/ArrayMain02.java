package edu.java.array02;
import java.lang.reflect.Array;

public class ArrayMain02 {

	public static void main(String[] args) {
		System.out.println("배열의 선언, 초기화, 출력");
		
		// int형 정수 10개를 저장할 수 있는 배열 선언
		int[] array = new int[10];
		
		// 배열의 길이 출력
		System.out.println("배열의 길이 : " + array.length);
		
		// 배열의 인덱스 : 0 ~ (length - 1)
		
		// for문을 사용하여 array 배열에 1 ~ 10까지의 값을 순차적으로 저장
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		// array[0] = 1
		// array[1] = 2
		// array[2] = 3
		// ...	

		// for문을 사용하여 배열의 모든 값을 출력
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// 오름차순 인덱스 : 0 ~ 9
		// 내림차순 인덱스 : 9 ~ 0
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
		
		// 0 ~ 9
		// array[?] ? : 9 ~ 0
		// 9 - 0 = 9
		// 9 - 1 = 8
		// 9 - 2 = 7
		// ...
		// 9 - 9 = 0
		// array.length - 1 - i
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[array.length - i - 1]);
		}
		
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("sum = " + sum);
	}

}
