package sunyeal;

import java.util.Scanner;

public class BubunUnion {
	
	static int n;
	static boolean[] ch;
	
	public static void dfs(int idx) {
		if(idx == n+1) {
			String tmp = "";
			for(int i=1; i<=n; i++) {
				if(ch[i] == true) tmp+= (i + " ");
			}
			if(tmp.length() > 0) System.out.println(tmp);
		} else {
			ch[idx] = true;
			dfs(idx + 1);
			ch[idx] = false;
			dfs(idx + 1);
		}
	}

	public static void main(String[] args) {
		// 부분집합 알고리즘 
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		ch = new boolean[n+1];
		
		dfs(1);

	}

}
