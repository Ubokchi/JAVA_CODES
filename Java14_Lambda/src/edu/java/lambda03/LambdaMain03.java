package edu.java.lambda03;

@FunctionalInterface
interface Test1 {
	public abstract void printMax(int x, int y);
}

@FunctionalInterface
interface Test2 {
	public abstract int findMax(int x, int y);
}

public class LambdaMain03 {

	public static void main(String[] args) {
		Test1 test1 = (x, y) -> {
			int max = (x > y) ? x : y;
			System.out.println("최대값: " + max);
		};
		test1.printMax(100, 101);
		
		Test2 test2 = (x, y) -> (x > y) ? x : y;
		System.out.println("최대값: " + test2.findMax(10, 5));
	}

}
