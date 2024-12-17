package codingTest.twoPointerSlidingWindow;

import java.util.Scanner;

public class Test4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = 0; 
		
		int lt = 0;
		int pdSum = 0;
		
		for(int rt=0; rt<n; rt++) {
			pdSum += arr[rt];
			
			if(pdSum == m) answer++;
			
			while(pdSum>=m) {
				pdSum -= arr[lt++];
				if(pdSum == m) answer++;
			}
			
		}
		
		System.out.println(answer);
		
	}
	

	

}
