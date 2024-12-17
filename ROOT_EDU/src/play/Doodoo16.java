package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Doodoo16 {

	public static void main(String[] args) throws IOException {
		// 최대 길이 연속부분수열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		// 투포인터 시작
		int lt = 0;
		int cnt = 0;
		int answer = Integer.MIN_VALUE;
		
		for(int rt=0; rt<arr.length; rt++) {
			
			if(arr[rt] == 0) cnt++;
			
			if(cnt > k) {
				while(cnt > k) {
					if(arr[lt++] == 0) cnt--;
				}
			}
			
			answer = Math.max(answer, rt - lt +1);
			
		}
		
		System.out.println(answer);
		

	}

}
