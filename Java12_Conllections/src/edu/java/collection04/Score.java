package edu.java.collection04;
//1. Score 클래스 생성
// - 멤버 변수(int math, int eng)
// - 생성자, getter/setter, toString() 생성
public class Score {
	private int math;
	private int eng;
	
	public Score() {}
	
	public Score(int math, int eng) {
		this.math = math;
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	@Override
	public String toString() {
		return "Score [math=" + math + ", eng=" + eng + "]";
	}
	
	
}
