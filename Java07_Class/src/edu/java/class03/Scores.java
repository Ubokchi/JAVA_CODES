package edu.java.class03;

public class Scores {
	// 멤버 변수(필드, 프로퍼티)
	int korean;
	int english;
	int math;
	
	public Scores() {}
	public Scores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public int calcTotal() {
		return korean + english + math;
	}
	
	public double calcAverage() {
		return calcTotal() / 3;
	}
	
	public void printScores() {
		System.out.println("국어: " + korean);
		System.out.println("영어: " + english);
		System.out.println("수학: " + math);
	}
}
