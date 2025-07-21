package edu.java.array08;

public class Solution {

	public static int solution(String my_string) {
		int answer = 0;
		String[] list = my_string.split(" ");
		
		answer = Integer.parseInt(list[0]);
		for (int i = 1; i < list.length; i += 2) {
			if (list[i].equals("+")) {
				answer += Integer.parseInt(list[i+1]);
			} else if (list[i].equals("-")) {
				answer -= Integer.parseInt(list[i+1]);
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String my_string = "3 + 4 + 5";
		System.out.println(solution(my_string));
	}
}
