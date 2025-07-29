package edu.java.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		Car car1 = new Car("롤스로이스");
		Car.Tire tire = car1.new Tire(20);
		tire.display();
	}

}
