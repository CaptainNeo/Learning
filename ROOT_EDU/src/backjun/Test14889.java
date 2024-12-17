package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test14889 {
	
	static int n;
	static int[][] board;
	static int answer = Integer.MAX_VALUE;
	static boolean[] team;
	static StringTokenizer st;
	
	public static void combi(int idx, int s) {
		
		if(s == n/2) { // 팀을 두개로 나누었으면 점수를 확인한다.
			/*for(boolean item : team) {
				System.out.print(item + " ");
			}
			System.out.println();*/
			ArrayList<Integer> slist = new ArrayList<Integer>();
			ArrayList<Integer> llist = new ArrayList<Integer>();
			
			for(int i=0; i<n; i++) {
				if(team[i]) {
					slist.add(i);
				}else {
					llist.add(i);
				}
			}
			
			// 1.점수 계산
			int startTeam = getPoint(slist);
			int linkTeam  = getPoint(llist);
			
			int possible = Math.abs(startTeam - linkTeam);
			
			answer = Math.min(answer, possible);
			return;
		}
		
		if(idx > n-1) return;
		team[idx] = true;
		combi(idx + 1, s + 1);
		team[idx] = false;
		combi(idx + 1, s);
		
	}

	public static void main(String[] args) throws IOException {
		// 스타트와 링크 겹치지 않는 조합 2개 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		team = new boolean[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 조합
		combi(0,0);
		
		System.out.println(answer);
		

	}
	
	static int getPoint(ArrayList<Integer> list) {
		int point = 0;
		
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				if(i == j) continue;
				point += board[list.get(i)][list.get(j)];
				point += board[list.get(j)][list.get(i)];
			}
		}
		
		return point;
	}// end for getStartPoint

}
