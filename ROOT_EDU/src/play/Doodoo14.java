package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Doodoo14 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 연속된 자연수의 합 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n/2 + 1];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		
		int lt = 0;
		
		int answer = 0;
		int sum = 0;
		
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
