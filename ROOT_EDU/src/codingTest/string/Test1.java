package codingTest.string;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		
		String b = sc.next();
		
		a = a.toUpperCase();
		b = b.toUpperCase();
		
		int cnt = 0;
		
		for(int i=0; i < a.length(); i++) {
			if(a.charAt(i) == b.charAt(0)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		

	}

}
