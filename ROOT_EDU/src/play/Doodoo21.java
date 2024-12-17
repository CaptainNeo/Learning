package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Doodoo21 {

	public static void main(String[] args) throws IOException {
		// k번째 큰 수 3개 뽑고 TreeSet에 저장 정렬 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
		
		// 3개 뽑기 
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int l=j+1; l<n; l++) {
					tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		int answer = 0;
		int cnt = 0;
		
		for(int x : tset) {
			cnt++;
			if(cnt == k) {
				answer = x;
				break;
			}
		}
		
		System.out.println(answer == 0 ? -1 : answer);

	}

}
