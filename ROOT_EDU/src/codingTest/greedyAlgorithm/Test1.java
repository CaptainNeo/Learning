package codingTest.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person>{
	int height;
	int weight;
	
	Person(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Person o) {
		
		return o.height - this.height;  // 내림차순
	}
}

public class Test1 {

	public static void main(String[] args) {
		// 그리디 알고리즘 
		// 현재 시점에 최선의 선택을 한다. 미래를 생각하지 않는다. 즉, 많은 경우의 수를 해당 시점에 고려하지 않는다.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			list.add(new Person(h, w));
		}
		
		Collections.sort(list);
		
		int cnt = 1;
		int maxWeight = list.get(0).weight;
		
		for(int i=1; i<n; i++) {
			if(list.get(i).weight > maxWeight) {
				maxWeight = list.get(i).weight;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		

	}

}
