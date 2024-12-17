package codingTest.stackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Stack<Integer> st = new Stack<>();
		
		for(char c : str.toCharArray()) {
			
			if(Character.isDigit(c)) {
				st.push(Character.getNumericValue(c));  // c - 48
			} else {
				int rt = st.pop();  // 먼저 뺴주는게 오른쪽 피연산자
				int lt = st.pop();
				if(c == '+') {
					st.push(lt + rt);
				} else if(c == '-') {
					st.push(lt - rt);
				} else if(c == '*') {
					st.push(lt * rt);
				} else {
					st.push(lt / rt);
				}
			}
			
		}
		
		System.out.println(st.get(0));

	}

}
