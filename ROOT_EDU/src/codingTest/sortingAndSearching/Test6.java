package codingTest.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0;i <n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] tmp = arr.clone();
		
		Arrays.sort(tmp);
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			if(arr[i] != tmp[i]) {
				answer += i+1 + " ";
			}
		}
		
		System.out.println(answer);

	}

}
