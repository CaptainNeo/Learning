package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Test1759 {
	
	static int l, c;
	static String[] arr;
	static ArrayList<String> list;
	static StringTokenizer st;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// 암호 만들기   2초 
		
		// 조합 L개 만들고 C문자 받는다. C개의 조합 암호들을 출력하는대 사전식으로 조합을 출력 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new String[c];
		visited = new boolean[c];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		combi(0, 0);
		
		for(String x : list) {
			System.out.println(x);
		}
		

	}
	
	public static void combi(int idx, int depth) {
		
		if(l == depth) {
			String str = "";
			for(int i=0; i<visited.length; i++) {
				if(visited[i] == true) {
					str += arr[i];
				}
			}
			
			// 최소1개의 모음 과 두개의 자음으로 확인
			if(check(str)) {
				list.add(str);
			}
			
			return;
		} else {
			if(idx == c) return;
			if(visited[idx] == false) {
				visited[idx] = true;
				combi(idx + 1, depth + 1);
				visited[idx] = false;
				combi(idx + 1, depth);
			}
		}
		
	}
	
	public static boolean check(String str) {
		boolean flag = false;
		// 한개의 모듬 2개의 자음 
		// l개의 조합길이중 2개이상만 
		int tmp = 0;
		if(str.indexOf("a") != -1 ) {
			// 한개의 모음이고 2개의 자음 확인 
			tmp++;
		}
		if(str.indexOf("e") != -1) {
			tmp++;
		}
		if(str.indexOf("i") != -1) {
			tmp++;
		}
		if(str.indexOf("o") != -1) {
			tmp++;
		}
		if(str.indexOf("u") != -1) {
			tmp++;
		}
		
		if(tmp > 0 && (l-tmp) >= 2) flag = true;
		
		
		return flag;
	}

}
