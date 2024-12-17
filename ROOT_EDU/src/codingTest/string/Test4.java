package codingTest.string;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();  // 숫자만 읽고 개행문자는 안읽네!!
		
		// 문자열을 돌때 시간복잡도는 물어보지 않았어 이중 포문해도 되겟네 그럼 어떻게 뒤로 돌릴거냐..
		
		sc.nextLine();  // 개행문자를 소비하여 버퍼를 비운다.  // 개행문자까지 읽음
		
		for(int i=0; i < n; i++) {
			String str = sc.nextLine();
			
			String answer = "";
			
			for(int l=str.length()-1; l >= 0; l-- ) {
				answer += str.charAt(l);
			}
			
			System.out.println(answer);
			
			// 또는 StringBuffer 사용
//			StringBuffer sb = new StringBuffer(str);
//			sb.reverse();
			
			
		}

	}

}

