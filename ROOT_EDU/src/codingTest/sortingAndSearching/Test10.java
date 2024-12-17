package codingTest.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
	
	public static int count(int[] arr, int dist) {
		int cnt = 1;
		
		int ep = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]-ep >= dist) {
				cnt++;
				ep=arr[i];
			}
		}
		
		
		return cnt;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); 
		
		int c = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int lt = 1; // 최단거리 먼저 
		int rt = arr[n-1];  // 최장거리 
		int answer = 0;
		
		while(lt<=rt) {
			int mid  = (lt + rt) / 2;
			
			if(count(arr, mid) >= c) {  // 이거리 mid 에 말을 c 마리 이상 세울수 있나 있으면 정답으로 간주
				answer = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
			
		}
		
		System.out.println(answer);

	}

}
