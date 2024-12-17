package codingTest.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Stack<Character> st = new Stack<>();
		
		for(char c : str.toCharArray()) {
			
			if(c == ')') {
				// 계속 팝해서 없애야되 ( 나올떄까지
				boolean flag = true;
				while(flag) {
					char ch = st.pop();
					if(ch == '(') flag = false;
				};
			} else {
				st.push(c);
			}
			
		}
		
		for(char c : st) {
			System.out.print(c);
		}

	}

}
