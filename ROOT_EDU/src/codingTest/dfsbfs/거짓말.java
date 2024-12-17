package codingTest.dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class ������ {
	
	public static int[] unf;
	public static int[] trueP;
	public static ArrayList<Integer>[] party;
	public static int result;

	public static void main(String[] args) {
		// ������ - �������Ҽ������鼭 ������  �� �ִ� ��Ƽ ������ �ִ��� ���϶�
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		result = 0;
		trueP = new int[T];
		
		for(int i=0; i<T; i++) {  // ������ �ƴ� ��� ����
			trueP[i] = sc.nextInt();
		}
		
		party = new ArrayList[M];  // ��Ƽ�� ������ŭ ����Ʈ �迭�� ����� 
		
		for(int i=0; i<M; i++) {	// ��Ƽ������ �����ϱ�
			party[i] = new ArrayList<Integer>();
			int party_size = sc.nextInt();
			for(int j=0; j<party_size; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		unf = new int[N+1];
		
		for(int i=0; i<=N; i++) {	// ��ǥ ��带 �ڱ� �ڽ����� �ʱ�ȭ�ϱ�
			unf[i] = i;
		}
		
		
		for(int i=0; i<M; i++) {  // �� ��Ƽ�� ������ ������� 1���� �׷����� �����
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		// �� ��Ƽ�� ��ǥ ���� ������ �ƴ� ������� ��ǥ ��尡 ���ٸ� ������ �� ���� 
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			
			int cur = party[i].get(0);
			
			for(int j=0; j<trueP.length; j++) {
				if(find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) result++;  // ��� �ٸ��� ����� 1 ����
			
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

