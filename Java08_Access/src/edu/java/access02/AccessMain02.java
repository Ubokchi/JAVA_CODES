package edu.java.access02;

import edu.java.access01.Test01;

public class AccessMain02 {

	public static void main(String[] args) {
		
		// command + Shift + o : 자동 import
		Test01 t1 = new Test01();
		
//		t1.n1 = 100; // private
//		t1.n2 = 200; // (package)
//		t1.n3 = 300; // protected
		t1.n4 = 400; // public
		t1.printFields();
	
	}
	
}
