package codingTest.twoPointerSlidingWindow;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = Integer.MIN_VALUE;
		int lt = 0;
		int cnt = 0;
		
		for(int rt=0; rt<arr.length; rt++) {
			if(arr[rt] == 0) cnt++;
			
			while(cnt > k) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			
			answer = Math.max(answer, rt - lt + 1);
			
		}
		
		System.out.println(answer);

	}

}
