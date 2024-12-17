package codingTest.hashmapTreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int k = sc.nextInt();
		
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		TreeSet<Integer> ts = new TreeSet<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int l=j+1; l<n; l++) {
					ts.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		int cnt = 0;
		int answer = -1;
		for(int x : ts) {
			cnt++;
			if(cnt == k) {
				answer = x;
				break;
			}
		}
		
		System.out.println(answer);
				

	}

}
