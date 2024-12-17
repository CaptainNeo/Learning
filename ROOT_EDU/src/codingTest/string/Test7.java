package codingTest.string;

import java.util.Scanner;

public class Test7 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 앞으로 읽으나 뒤로 읽으나 똑같은지 회문 문자열 확인 맞으면 'YES' 아니면 'NO'
//		앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
//
//		문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
//
//		단 회문을 검사할 때 대소문자를 구분하지 않습니다.
		String lStr = sc.nextLine();
		
		String rStr = new StringBuilder(lStr).reverse().toString();
		
		lStr = lStr.toUpperCase();
		rStr = rStr.toUpperCase();
		
		String answer = "YES";
		
		if(!lStr.equals(rStr)) {
			answer = "NO";
		}
			
		
		System.out.println(answer);
		
		// 선생님은 str.charAt(i) != str.charAt(len - i -1) 로 하셧네
		
		
		
	}

}
