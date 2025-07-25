package edu.java.inherit07;

class ParentClass {
	private int x;
	
	public ParentClass(int x) {
		this.x = x;
		System.out.println("ParentClass(X) 생성자");
	}
	
	public int getX() {
		return x;
	}
}

class ChildClass extends ParentClass {
	private int y;
	
	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("ChildClass(x, y) 생성자");
	}
	
	public int getY() {
		return y;
	}
}

public class InheritMain07 {

	public static void main(String[] args) {
		ParentClass class1 = new ChildClass(100, 200); // 다형성
		System.out.println();
		ChildClass class2 = new ChildClass(300, 400);
		
		ParentClass class3 = new ParentClass(100);
		class2.getX();
		class2.getY();
		
		class1.getX();
//		class1.getY();
		// class1은 ParentClass 타입으로 선언했기 때문에
		// ChildClass에서 정의한 getY() 메소드를 사용할 수 없음
		// 다만, 실제 인스턴스는 ChildClass 타입이기 때문에
		// 강제 형 변환(casting)을 하면, 사용이 가능
		ChildClass c = (ChildClass) class1;
		System.out.println(c.getY());
		System.out.println(((ChildClass) class1).getY());
		
		ParentClass[] pcs = new ParentClass[3];
		pcs[0] = class1;
		pcs[1] = class2;
		pcs[2] = class3;
		System.out.println("==========");
		System.out.println(class1 instanceof ChildClass);
		// instanceof : 인스턴스와 클래스가 같은 타입인지 확인하는 키워드
		
		for(int i = 0; i < pcs.length; i++) {
			if(pcs[i] instanceof ChildClass) { 
				// 배열의 인스턴스가 ChildClass인 경우에 형변환
				System.out.println(pcs[i].getX());
				System.out.println(((ChildClass) pcs[i]).getY());
			} else {
				// 배열의 인스턴스가 ChildClass가 아닌 경우
				System.out.println(pcs[i].getX());
			}
		}
		
	}

}






