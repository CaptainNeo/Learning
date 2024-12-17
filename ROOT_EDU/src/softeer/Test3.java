package softeer;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = n-1;
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			max = Math.max(max, num);
		}
		
		answer += max;
		
		System.out.println(answer);
		

	}

}
