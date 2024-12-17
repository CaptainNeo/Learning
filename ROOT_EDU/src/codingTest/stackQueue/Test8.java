package codingTest.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	int id;
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}

public class Test8 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Queue<Person> q = new LinkedList<>();
				
		for(int i=0; i<n; i++) {
			q.offer(new Person(i, sc.nextInt()));
		}
		
		int answer = 0;
		boolean flag = true;
		
		while(flag) {
			
			Person p = q.poll();
			
			for(Person x : q) {
				if(x.priority > p.priority) {
					q.offer(p);
					p = null;
					break;
				}
			}
			
			if(p != null) {
				answer++;
				if(p.id == m) {
					flag = false;
				}
			}
			
		}
		
		System.out.println(answer);
		
		

	}

}
