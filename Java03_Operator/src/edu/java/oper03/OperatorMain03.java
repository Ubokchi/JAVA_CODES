package edu.java.oper03;

// 증감 연산자
// - 변수의 값을 1 증가 또는 감소할 때 사용하는 연산자
// - 변수의 앞(prefix)과 뒤(suffix)에 사용
// - ++, --
public class OperatorMain03 {

   public static void main(String[] args) {
      System.out.println("증감 연산자(++, --)");
      
      int num1 = 100;
      num1++;
      // num1 += 1;
      // num1 = num1 + 1;
      System.out.println("num1 = " + num1);
      
      int num2 = 100;
      ++num2;
      System.out.println("num2 = " + num2);
      
      int num3 = 100;
      int result = ++num3 + 5; // num3 = 101이 되고, +5를 실행
      System.out.println("num3 = " + num3);
      System.out.println("result = " + result);
      
      int num4 = 100;
      result = num4++ + 5;
      // num4(100) + 5가 먼저 수행되고, num4++(101)가 수행
      // 100 + 5가 result에 저장
      System.out.println("num4 = " + num4);
      System.out.println("result = " + result);
      
      int x = 10;
      result = x++ + 5 + ++x;
      // 연산 구조는 순차적으로 이루어진다.
      // 예) 1 + 2 + 3 => (1 + 2 = 3) + 3 = 6
      // 퀴즈) result의 값과 그 이유 설명하기      
      
      // 계산 순서
      // 1. x++ + 5
      //      (1) x + 5 ==> 10 + 5 ==> 15
      //      (2) x 증가 ==> x = 11
      // 2. 15 + ++x
      //      (1) x 증가 ==> x = 12
      //      (2) 15 + 12 = 27
      // 3. result = 27

   }

}