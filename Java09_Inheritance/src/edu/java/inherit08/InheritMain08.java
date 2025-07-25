package edu.java.inherit08;

public class InheritMain08 {

	public static void main(String[] args) {
		// Employee 클래스 타입의 배열 선언
		Employee[] emps = {
				new Employee("홍길동"),
				new Manager("과장")
		};
		
		System.out.println(emps[0] instanceof Employee);
		System.out.println(emps[1] instanceof Employee);
		System.out.println(emps[1] instanceof Manager);

		for(Employee e : emps) {
			printEmpInfo(e);
			System.out.println("-----------");
		}
	}

	// Employee e 매개변수에 저장되는 인스턴스는
	// Employee 객체일 수도 있고, Manager 객체일 수도 있음
	// 조건문과 instanceof를 이용하여 타입에 따른 데이터 출력 코드를 작성
	private static void printEmpInfo(Employee e) {
		if(e instanceof Manager) {
			Manager m = (Manager) e; // 강제 형 변환
			System.out.println("직책 : " + m.getType());
		} else if(e instanceof Employee) {
			System.out.println("이름 : " + e.getName());
		} else {
			System.out.println("직원이 아닙니다.");
		}
	}

}









