package codingTest.string;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Test6 {

	public static void main(String[] args) {
		
		// ���� ���� �ϽǶ� indexOf�� ������ Ǯ���˾��� 
		
		Scanner sc = new Scanner(System.in);
		
		String string = sc.nextLine();
		
		String answer = "";
		
		for(int i=0; i<string.length(); i++) {
			if(string.indexOf(string.charAt(i)) == i)
				answer += string.charAt(i);
		}
		
		System.out.println(answer);
		
//		Set<String> setObj = new LinkedHashSet<String>();
//		
//		char[] cArr = string.toCharArray();
//		
//		for(char c : cArr) {
//			setObj.add(String.valueOf(c));
//		}
//		
//		String answer = "";
//		
//		for(String s : setObj) {
//			answer += s;
//		}
//		
//		System.out.println(answer);

	}

}
