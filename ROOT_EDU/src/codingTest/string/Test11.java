package codingTest.string;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String scr = sc.nextLine();
		scr += " ";  // 하나 더 늘려서 압축
		
		int cnt = 1;
		
		String answer = "";
		
		for(int i=0; i<scr.length()-1; i++) {
			if(scr.charAt(i) == scr.charAt(i + 1)) cnt++;
			else {
				answer += scr.charAt(i);
				if(cnt > 1) answer += String.valueOf(cnt);
				cnt = 1;
			}
		}
		
		
		System.out.println(answer);
		

	}

}
