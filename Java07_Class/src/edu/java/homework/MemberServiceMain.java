package edu.java.homework;

import java.util.Scanner;

public class MemberServiceMain {

   public static void main(String[] args) {
      MemberService memberService = new MemberService();
      
      Scanner sc = new Scanner(System.in);
      String id = sc.next();
      String pw = sc.next();
      
      boolean result = memberService.login(id, pw);
      if(result) {
    	  // id, pw가 "test", "1234"인 경우에만 로그인 되도 
         System.out.println("로그인 되었습니다.");
         memberService.logout(id);
      } else {
         System.out.println("id 또는 password가 올바르지 않습니다.");
      }

   }

}
