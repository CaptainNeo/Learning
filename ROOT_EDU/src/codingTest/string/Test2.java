package codingTest.string;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		// 소문자는 대문자로. 대문자는 소문자로 
		
		char[] cs = str.toCharArray();
		
		// 24개 차이나는건 알고있고 a와 A 캐릭터 셋이 어떻게 되는지를 알아야되   a 가 97 이고 A는 65             65 ~ 90 이 대문자,  97 ~ 122 가 소문자
		
		String answer = "";
		
		for(int i=0; i < str.length(); i++) {
			if( (int)cs[i] >= 65 && (int) cs[i] <= 90) {
				answer += String.valueOf(cs[i]).toLowerCase();
			} else {
				answer += String.valueOf(cs[i]).toUpperCase();
			}
		}
		
		System.out.println(answer);
		
		
	}

}
