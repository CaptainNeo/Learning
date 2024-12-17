package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test18185 {

	public static void main(String[] args) throws IOException {
		// 라면사기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		// 최소비용 
		for(int i=0; i<n; i++) {
			
			int tmp = arr[i];
			
			answer += 3 * arr[i];
			
			tmp = Math.min(arr[i], arr[i+1]); // 2
			
			answer += 2 * tmp;
			
			arr[i+1] -= tmp; // a[i+1] == 1
			
			tmp = Math.min(tmp, arr[i+2] - Math.min(arr[i+1], arr[i+2]));
			
			answer += 2 * tmp;
			
			arr[i+2] -= tmp;
			
		}
		
		System.out.println(answer);
		

	}

}
