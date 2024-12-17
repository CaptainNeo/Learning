package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Doodoo30 {

	public static void main(String[] args) throws IOException {
		// 중복 확인 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String answer = "U";
		
		Arrays.sort(arr);  //
//		Arrays.sort(arr, Collections.reverseOrder());  Integer 타입으로 변경해야한다.
		
		for(int i=0; i<n-1; i++) {
			
			if(arr[i] == arr[i+1]) {
				answer = "D";
				break;
			}
			
		}
		
		System.out.println(answer);

	}

}
