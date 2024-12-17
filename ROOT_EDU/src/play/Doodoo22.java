package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Doodoo22 {

	public static void main(String[] args) throws IOException{
		// ¿Ã¹Ù¸¥ °ýÈ£ 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		boolean flag = true;
		
		for(char c : str.toCharArray()) {
			if(stack.size() == 0 && c == ')') {
				flag = false;
				break;
			}
			
			if('(' == c) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		
		if(!flag) {
			System.out.println("NO");
		} else {
			if(stack.isEmpty()) 
				System.out.println("YES");
			else
				System.out.println("NO");
		}
			
		

	}

}
