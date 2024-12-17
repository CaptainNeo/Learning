package codingTest.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test9 {
	
	public static int count(int[] arr, int capacity) {
		int cnt = 1; 
		int sum = 0;
		for(int x : arr) {
			if(sum+x > capacity) {
				cnt++;
				sum = x;
			} else {
				sum += x;
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		
		// 결정알고리즘 주어진 범위 내에서 원하는 값 또는 원하는 조건에 가장 일치하는 값을 찾아내는 알고리즘 
		// 이진탐색 패턴을 기반 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		int mid;
		int answer = 0;
		
		while(lt<=rt) {
			
			mid = (lt + rt) / 2;
			
			if(count(arr,mid) <= m) {
				answer = mid;
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
			
		}
		
		System.out.println(answer);

	}

}
