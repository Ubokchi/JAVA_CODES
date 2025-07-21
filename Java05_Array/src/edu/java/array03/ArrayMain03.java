package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {
	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		// 퀴즈) n명의 학생 점수를 입력받아 배열에 저장하고
		// 총합, 평균, 최대갑, 최소값 출력
		// * n 명은 console에서 입력받고 입력받은 인원 수로 배열 사이즈 설정 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		int n = sc.nextInt(); 
		
		int[] scores = new int[n];
	    int sum = 0;
	    int max = Integer.MIN_VALUE; 
	    int min = Integer.MAX_VALUE; 

	    for (int i = 0; i < n; i++) {
	    	System.out.print((i + 1) + "번째 학생 점수 입력 : ");
	        scores[i] = sc.nextInt();

	        sum += scores[i];

            if (scores[i] > max) {
                max = scores[i];
            }

            if (scores[i] < min) {
                min = scores[i];
            }
        }

        double avg = (double) sum / n;
        
        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
        
        // n명의 점수 출력
        for(int i = 0; i < scores.length; i++) {
        	System.out.printf("scores[%d] = %d\n", i, scores[i]);
        }
        
	}
	
	
}
