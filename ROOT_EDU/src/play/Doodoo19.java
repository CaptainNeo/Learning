package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Doodoo19 {

	public static void main(String[] args) throws IOException {
		// 매출액의 종류 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int lt = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(map.size() + " ");
		
		
		for(int rt=k; rt<n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			
			int ltInt = map.get(arr[lt]) - 1;
			
			if(ltInt == 0) {
				map.remove(arr[lt++]);
			} else {
				map.put(arr[lt++], ltInt);
			}
			
			sb.append(map.size() + " ");
			
		}
		
		System.out.println(sb);

	}

}
