package play;

import java.util.Scanner;

public class Doodoo12 {

	public static void main(String[] args) {
		// 최대 매출
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int maxEarn = 0;
		int answer = 0;
		
		for(int i=0; i<k; i++) {
			maxEarn += arr[i];
			answer  += arr[i];
		}
		
		int lt = 0;
		
		for(int rt=k; rt<n; rt++) {
			maxEarn += arr[rt];
			maxEarn -= arr[lt];
			lt++;
			answer = Math.max(answer, maxEarn);
		}
		
		System.out.println(answer);

	}

}
