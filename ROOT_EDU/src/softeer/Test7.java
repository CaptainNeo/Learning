package softeer;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(y < min) {
				min = y;
				answer = x + " " + y;
			}
		}
		
		System.out.println(answer);
		

	}

}
