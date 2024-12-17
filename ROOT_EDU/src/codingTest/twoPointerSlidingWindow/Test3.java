package codingTest.twoPointerSlidingWindow;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int answer = 0;
		int sum = 0;
		
		for(int i=0; i<k; i++) {  // 연속된 k일을 미리 더해준다.
			sum += a[i];  // 
		}
		
		answer = sum;
		
		for(int i=k; i<n; i++) {
			sum += a[i] - a[i-k];
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);

	}

}
