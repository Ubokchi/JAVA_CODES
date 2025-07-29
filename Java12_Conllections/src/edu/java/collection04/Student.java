package edu.java.collection04;
//2. Student 클래스 생성
// - 멤버 변수(String name, Score score)
// - 생성자, getter/setter, toString() 생성
public class Student {
	private String name;
	private Score score;
	
	public Student() {}

	public Student(String name, Score score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	
	
}
