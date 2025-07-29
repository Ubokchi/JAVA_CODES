package edu.java.lambda01;

// FunctionalInterface: 추상메소드가 하나뿐인 메소드
// 람다 표현식은 functional interface만 사용 가능

@FunctionalInterface
public interface Adder {
	public abstract double add(double x, double y);
}
