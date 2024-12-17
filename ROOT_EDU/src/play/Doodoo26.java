package play;

import java.util.Scanner;
import java.util.Stack;

public class Doodoo26 {

	public static void main(String[] args) {
		// 쇠막대기 
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Stack<Character> stack = new Stack<>();
		
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				// 닫는괄호인대 레이저인지 막대의 끝인지 확인
				// 레이저 먼저 
				stack.pop();
				if(str.charAt(i-1) == '(') {
					answer += stack.size();
				} else {
					answer += 1;
				}
			}
			
		}
		
		System.out.println(answer);

	}

}
