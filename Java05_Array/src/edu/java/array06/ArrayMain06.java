package edu.java.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		//문자열(String)은 문자(char)의 배열이다.
		
		String str = "내일은 쉬는날!";
		System.out.println(str.length());
		
		// 내 일 은  쉬 는 날 ! 출력
		for (int i = 0; i <str.length(); i++) {
			System.out.print(str.charAt(i) + " ");
		}
		
		System.out.println();
		// 문자열에 은 이라는 글자가 있으면 반복문 종료
		for (int i = 0; i <str.length(); i++) {
			System.out.print(str.charAt(i));
			if (str.charAt(i) == '은') {
				break;
			}
		}
		
		System.out.println();
		// 문자열 배열 선언
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		
		for(int i = 0; i < subjects.length; i++) {
			System.out.println("과목명: " + subjects[i]);
			System.out.println("문자열 길이: " + subjects[i].length());
		}
		
		// subjects 문자열 배열에서 '어'라는 글자가 몇 개인지 출력
		int count = 0;
		for(int i = 0; i < subjects.length; i++) {
			count = 0;
			for (int j = 0; j < subjects[i].length(); j++) {
				if (subjects[i].charAt(j) == '어')
					count++;
			}
			System.out.println(subjects[i]+ "의 글자 수: " + count);
		}
	}

}
