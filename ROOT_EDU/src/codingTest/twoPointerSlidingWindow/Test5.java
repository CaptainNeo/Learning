package codingTest.twoPointerSlidingWindow;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n/2 + 1];
		
		int sum = 0;
		
		int answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		int lt = 0;
		
		for(int rt=0; rt<arr.length; rt++) {
			sum += arr[rt];
			
			if(sum == n) answer++;
			
			while(sum >= n) {
				sum -= arr[lt++];
				if(sum == n) answer++;
			}
		}
		
		System.out.println(answer);
		

	}

}