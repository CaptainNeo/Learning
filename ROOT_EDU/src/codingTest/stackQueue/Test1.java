package codingTest.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		
		Stack<Character> stack = new Stack<>();
		String answer = "YES";
		
		for(char s : str.toCharArray()) {
			
			if(s == '(') {
				stack.push(s);
			} else {
				if(stack.isEmpty()) {
					answer = "NO";
					break;
				}
				stack.pop();
			}
			
		}
		
		
		if(!stack.isEmpty()) answer = "NO";
		
		System.out.println(answer);
		
		
		
		

	}

}
