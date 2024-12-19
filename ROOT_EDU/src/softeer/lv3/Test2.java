package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2 {
	
	static StringTokenizer st;
	static int n,m,k;
	static int[] rails, pm;
	static boolean[] check;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 택배마스터 광우 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		rails = new int[n];
		pm = new int[n];
		check = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) rails[i] =  Integer.parseInt(st.nextToken());
		
		combi(0);
		
		System.out.println(answer);

	}
	
	public static void combi(int idx) {
		if(idx == n) {
			computeAns(pm);
//			for(int x : pm) System.out.print(x + " ");
//			System.out.println();
			return;
		} else {
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					pm[idx] = rails[i];
					check[i] = true;
					combi(idx + 1);
					check[i] = false;
				}
			}
		}
	}
	
	
	public static void computeAns(int[] arr) {
		int bucket = 0, total = 0, idx = 0;
		
		for(int i=0; i<k; i++) {
			while(bucket+arr[idx] <= m) {
				bucket += arr[idx];
				idx = (idx+1)%n;
			}
			total += bucket;
			bucket = 0;
		}
		answer = Math.min(answer, total);
	}

}
