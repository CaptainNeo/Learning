package codingTest.string;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		// 특정문자열 뒤집기 
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		char[] cArr = str.toCharArray();  // char 배열로 만들어주고
		
		int lt = 0;  // 영어 알파벳만뒤집기 위해서 index 확인용으로 lt, rt 초기화 
		int rt = cArr.length - 1;
		
		while(lt < rt) {  // 두개의 인덱스가 붙을때까지 
			if(!Character.isAlphabetic(cArr[lt])) {
				lt++;
			}
			else if(!Character.isAlphabetic(cArr[rt])) {
				rt--;
			}
			else {
				char tmp = cArr[lt];
				cArr[lt] = cArr[rt];
				cArr[rt] = tmp;
				lt++; rt--;  // 두개를 좁혀 
			}
		}
		
		System.out.println(String.valueOf(cArr));
		

	}

}

