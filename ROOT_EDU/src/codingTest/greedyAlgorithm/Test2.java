package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Plan implements Comparable<Plan>{
	int st;
	int et;
	
	Plan(int st, int et) {
		this.st = st;
		this.et = et;
	}

	@Override
	public int compareTo(Plan o) {
		// TODO Auto-generated method stub
		if(this.et == o.et) return this.st - o.st;
		else return this.et - o.et; 
	}
}

public class Test2 {
	
	public static void main(String[] args) {
		
		// 회의실 배정 
		// 지금현재 최선의 선택의 조건은 회의가 빨리 종료되는 시점부터 채워 넣는게 최선이다.
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Plan> list = new ArrayList<>();
		
		for(int i=0 ;i<n; i++) {
			int st = sc.nextInt();
			int et = sc.nextInt();
			list.add(new Plan(st, et));
		}
		
		Collections.sort(list);
		
		int cnt = 1;
		int maxEt = list.get(0).et;
		for(int i=1; i<n; i++) {
			if(list.get(i).st >= maxEt) {
				maxEt = list.get(i).et;
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
