package codingTest.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Stack<Character> st = new Stack<>();
		
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) == ')') {
				if(str.charAt(i-1) == ')') {
					st.pop();
					answer += 1;
				} else if(!st.isEmpty() && st.peek() == '(') {
					// ·¹ÀÌÀú 
					st.pop();
					answer += st.size();
				}
			} else {
				st.push(str.charAt(i));
			}
			
		}
		
		System.out.println(answer);

	}

}
