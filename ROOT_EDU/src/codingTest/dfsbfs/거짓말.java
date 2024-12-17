package codingTest.dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 거짓말 {
	
	public static int[] unf;
	public static int[] trueP;
	public static ArrayList<Integer>[] party;
	public static int result;

	public static void main(String[] args) {
		// 거짓말 - 거짓말할수있으면서 참석할  수 있는 파티 개수의 최댓값을 구하라
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		result = 0;
		trueP = new int[T];
		
		for(int i=0; i<T; i++) {  // 진실을 아는 사람 저장
			trueP[i] = sc.nextInt();
		}
		
		party = new ArrayList[M];  // 파티의 개수만큼 리스트 배열을 만들어 
		
		for(int i=0; i<M; i++) {	// 파티데이터 저장하기
			party[i] = new ArrayList<Integer>();
			int party_size = sc.nextInt();
			for(int j=0; j<party_size; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		unf = new int[N+1];
		
		for(int i=0; i<=N; i++) {	// 대표 노드를 자기 자신으로 초기화하기
			unf[i] = i;
		}
		
		
		for(int i=0; i<M; i++) {  // 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음 
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			
			int cur = party[i].get(0);
			
			for(int j=0; j<trueP.length; j++) {
				if(find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) result++;  // 모두 다르면 결과값 1 증가
			
		}
		
		System.out.println(result);
		
		

	}
	
	public static void union(int fa, int fb) {
		fa = find(fa);
		fb = find(fb);
		if(fa != fb) {
			unf[fa] = fb;
		}
	}
	
	public static int find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = find(unf[v]);
	}
	

}



//8 5
//3 1 2 7
//2 3 4
//1 5
//2 5 6
//2 6 8
//1 8

