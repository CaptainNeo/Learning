package codingTest.string;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		
		String answer = "";
		
		
		for(int i=0; i<cnt; i++) {
			
			String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
			int num = Integer.parseInt(tmp, 2);
			answer += (char) num;
			str = str.substring(7);
			
		}  // end for loop
		
		
		
		System.out.println(answer);

	}

}
