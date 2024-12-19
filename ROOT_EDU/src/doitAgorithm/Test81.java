package doitAgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test81 {
	
	static int n, k, cnt;
	static int[] arr, pm;
	static int[] tmp;
	static boolean[] check;
	static StringTokenizer st;
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		// 순열의 순서 구하기 2개의 소문제 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		pm = new int[n];
		check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i + 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int se = Integer.parseInt(st.nextToken());
		
		if(se == 1) {
			k = Integer.parseInt(st.nextToken());
			cnt = 0;
			permu1(0);
		} else {
			tmp = new int[n];
			for(int i=0; i<n; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
			}
			permu2(0);
		}
		
		

	}
	
	public static void permu1(int idx) {
		
		if(!flag) return;
		
		if(idx == n) {
			cnt++;
			if(cnt == k) {
				flag = false;
				for(int x=0; x<n; x++) {
					System.out.print(pm[x] + " ");
				}
			}
		} else {
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					check[i] = true;
					pm[idx] = arr[i];
					permu1(idx + 1);
					check[i] = false;
				}
			}
		}
		
	}
	
	public static void permu2(int idx) {
		
		if(!flag) return;
		
		if(idx == n) {
			cnt++;
			if(Arrays.equals(tmp, pm)) {
				System.out.println(cnt);
				flag = false;
				return;
			}
		} else {
			for(int i=0; i<n; i++) {
				if(check[i] == false) {
					check[i] = true;
					pm[idx] = arr[i];
					permu2(idx + 1);
					check[i] = false;
				}
			}
		}
		
	}

}
