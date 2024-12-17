package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Company implements Comparable<Company>{
	int money;
	int days;
	
	Company(int money, int days) {
		this.money = money;
		this.days = days;
	}

	@Override
	public int compareTo(Company o) {
		return o.days - this.days;
	}
}

public class Test4 {

	public static void main(String[] args) {
		// 최대 수입 스케쥴 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Company> list = new ArrayList<>();
		
		int maxDays = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			int money = sc.nextInt();
			int days  = sc.nextInt();
			maxDays = Math.max(maxDays, days);
			list.add(new Company(money, days));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		int earn = 0;
		int j = 0;
		for(int i=maxDays; i>0; i--) {
			// 3일부터 큐에 다담아 먼저 
			for(; j<n; j++) {
				if(list.get(j).days < i) break; 
				q.offer(list.get(j).money);
			}
			// max일차부터 차례대로 더해
			if(!q.isEmpty()) earn += q.poll();
			
		}
		
		System.out.println(earn);

	}

}
