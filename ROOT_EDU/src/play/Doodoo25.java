package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Doodoo25 {

	public static void main(String[] args) throws IOException {
		// 후위식 연산 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();
		
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				stack.push(String.valueOf(str.charAt(i)));
			} else {
				int rt = Integer.parseInt(stack.pop());
				int lt = Integer.parseInt(stack.pop());
				int tmp = 0;
				
				char se = str.charAt(i);
				
				if(se == '+') {
					tmp = lt + rt;
				} else if(se == '-') {
					tmp = lt - rt;
				} else if(se == '*') {
					tmp = lt * rt;
				} else {
					tmp = lt / rt;
				}
				
				stack.push(String.valueOf(tmp));
				
			}
		}
		
		System.out.println(stack.pop());
		
		

	}

}
