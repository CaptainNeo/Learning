package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_2 {
	
	static int n,m,k;
	static int[] arr;
	static int[] pm;
	static boolean[] check;
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 택배 마스터 광우 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		pm = new int[n];
		check = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(0);
		
		System.out.println(answer);

	}
	
	public static void permu(int idx) {
		
		if(idx == n) {
			calc();
//			for(int x : pm) {
//				System.out.print(x + " ");
//			}
//			System.out.println();
			return;
		}else {
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					check[i] = true;
					pm[idx] = arr[i];
					permu(idx + 1);
					check[i] = false;
				}
			}
		}
		
	}
	
	public static void calc() {
		
		int bucket = 0; int total = 0; int idx = 0;
		
		for(int i=0; i<k; i++) {
			
			while(bucket + pm[idx] <=m) {
				bucket += pm[idx];
				idx = (idx + 1) % n;
			}
			total += bucket;
			bucket = 0;
		}
		
		answer = Math.min(answer, total);
		
	}

}
