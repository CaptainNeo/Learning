package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// ¡�˴ٸ�
		// ���������� ���鼭 ¡�˴ٸ� ���� ���� �� �ִ� �ִ� ���� (*���� ���̰� ���� �����͸� ��´�)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp  = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			dp[i] = 1;  // �ּ� �ϳ��� ��� �ǳʰ��ٰ� ���� 
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
