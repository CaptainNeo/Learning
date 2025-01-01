package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Doodoo38 {
	
	static int n;
	static Integer[] arr;
	static int m;
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;
	
	public static void dfs(int l, int sum) {  // 중복 순열 같은거야!
		
		if(sum > m) return;
		if(l >= answer) return;
		
		if(sum == m) {
			answer = Math.min(answer, l);
		} else {
			for(int i=0; i<n; i++) {
				dfs(l+1, sum + arr[i]);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// 동전교환 
		// 첫 번쨰 줄에 거슬러 줄 동전의 최소개수를 출력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new Integer[n];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		m = Integer.parseInt(br.readLine());
		
		dfs(0,0);
		
		System.out.println(answer);

	}

}
