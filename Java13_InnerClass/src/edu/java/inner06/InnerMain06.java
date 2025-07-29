package edu.java.inner06;

interface PersonInterface {
	void showInfo();
	void hello();
}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public PersonInterface setAge(int age) {
		// 지역 클래스
		class PersonWithAge implements PersonInterface {
			private int age;

			public PersonWithAge(int age) {
				this.age = age;
			}

			@Override
			public void showInfo() {
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
			}

			@Override
			public void hello() {
				System.out.println("안녕하세요!");
			}

		}

		PersonWithAge instance = new PersonWithAge(age);
		return instance;
	}

}

public class InnerMain06 {
	public static void main(String[] args) {
		Person p = new Person("복치");
		PersonInterface instance = p.setAge(20);
		instance.showInfo();
		instance.hello();
	}
}
