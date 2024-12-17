package codingTest.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Queue<Character> q = new LinkedList<>();
		
		String testStr = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			q.offer(str.charAt(i));
		}
		
		for(int i=0; i<testStr.length(); i++) {
			if(q.contains(testStr.charAt(i)) && q.peek() == testStr.charAt(i)) {
				q.poll();
			}
		}
		
		String answer = "YES";
		
		if(q.size() > 0) answer = "NO";
		
		System.out.println(answer);

	}

}
