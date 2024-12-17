package codingTest.array;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] intArr = new int[n];
		
		int cnt = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			if(intArr[i] == 1) {
				cnt++;
				sum += cnt;
			} else 
				cnt = 0;
			
		}
		
		
		System.out.println(sum);
		
		
		

	}

}
