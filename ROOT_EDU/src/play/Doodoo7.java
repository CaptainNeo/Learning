package play;

import java.util.Scanner;

public class Doodoo7 {

	public static void main(String[] args) {
		
		// 문자열 문제 
		
		// 2진수로 만들기 # -> 1 , * -> 0 
		// 2진수를 10진수 화시킨다 그럼 숫자가 나오면 그 캐릭터가 문자다 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		String str = sc.nextLine();
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
			int num = Integer.parseInt(tmp, 2);
			answer += (char) num;
			str = str.substring(7);
		}
		
		System.out.println(answer);

	}

}
