package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// 징검다리
		// 오른쪽으로 가면서 징검다리 돌을 밝을 수 있는 최대 개수 (*돌의 높이가 점점 높은것만 밝는다)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp  = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			dp[i] = 1;  // 최소 하나는 밝고 건너간다고 가정 
		}
		
		int answer = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			 
			int max = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			
		}
		
		for(int x : dp) answer = Math.max(answer, x);
		
		System.out.println(answer);
		
		

	}

}
