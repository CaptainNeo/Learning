package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doodoo32 {

	public static void main(String[] args) throws IOException {
		// 이분검색
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);  // 오름차순 정렬해서 m의 값 위치 찾기 
		
		 int lt = 0;
		 int rt = n-1;
		 
		 int answer = 0;
		 
		 while(lt<=rt) {
			 
			 int mid = (lt + rt) / 2;
			 
			 if(arr[mid] == m) {
				 answer = mid + 1;
				 break;
			 }
			 
			 if(arr[mid] > m) {
				 rt = mid - 1;
			 } else {
				 lt = mid + 1;
			 }
			 
		 }
		 
		 System.out.println(answer);
				
		
		
		
		
				

	}

}
