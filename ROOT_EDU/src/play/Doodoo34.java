package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doodoo34 {
	
	public static int count(int[] arr, int dist) {
		
		int endPoint = arr[0];  // 시작점부터 넣자
		int cnt = 1;  // 말을 첫번째에서부터 넣었다고 하자.
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] - endPoint >= dist) {  // 이분검색으로 해당거리만큼 말을 놓는다는 정의
				cnt++;
				endPoint = arr[i];
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// 마구간 정하기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int lt = 1;
		int rt = arr[n-1];
		int answer = 0;
		
		while(lt<=rt) {
			
			int mid = (lt+rt) / 2;
			
			if(count(arr, mid) >= c) {
				answer = mid;
				lt = mid+1;
			} else {
				rt = mid-1;
			}
			
		}
		
		
		System.out.println(answer);
		
		

	}

}
