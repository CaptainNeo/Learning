package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doodoo31 {

	public static void main(String[] args) throws IOException {
		// 장난꾸러기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] tmp = new int[n]; // 정렬을 하자 ! 
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			tmp[i] = num;
		}
		
		Arrays.sort(tmp);
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			if(arr[i] != tmp[i]) answer += i+1 + " ";
		}
		
		System.out.println(answer);
		

	}

}
