package codingTest.dynamicProgramming;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dy = new int[n];
		
		dy[0] = 1;
		
		for(int i=1; i<n; i++) {
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j] && dy[j] > max) {
					max = dy[j];
				}
			}
			dy[i] = max + 1;
		}
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dy[i]);
		}
		
		System.out.println(answer);
				

	}

}
