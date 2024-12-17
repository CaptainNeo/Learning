package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Doodoo33 {
	
	public static int recording(int[] arr, int mid) {
		
		int recoCnt = 1;
		int recoMinute = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(recoMinute + arr[i] > mid) {
				recoCnt++;
				recoMinute = arr[i];
			} else {
				recoMinute += arr[i];
			}
		}
		
		
		return recoCnt;
	}

	public static void main(String[] args) throws IOException {
		// 뮤직비디오 (결정알고리즘)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		int lt = 0, rt = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			lt = Math.max(arr[i], lt);
			rt += arr[i];
			
		}
		
		int minute = 0;  // 해답 
		
		while(lt<=rt) {
			
			int mid = (lt + rt) / 2;
			
			int closeAnswer = recording(arr, mid); 
			
			if(closeAnswer != 0 && closeAnswer <= m) {
				minute = mid;
				rt = mid -1;
			} else {
				lt = mid + 1;
			}
			
		}
		
		System.out.println(minute);
		
		
		

	}

}
