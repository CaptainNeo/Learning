package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Doodoo23 {

	public static void main(String[] args) throws IOException {
		// 괄호문자제거 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			} else {
				if(c == ')') {
					boolean flag = true;
					while(flag) {
						if(stack.pop() == '(') flag = false;
					}
				} else {
					stack.push(c);
				}
			}
		}
		
		Iterator<Character> c = stack.iterator();
		
		StringBuilder sb = new StringBuilder();
		
		while(c.hasNext()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb.reverse());
		

	}

}
