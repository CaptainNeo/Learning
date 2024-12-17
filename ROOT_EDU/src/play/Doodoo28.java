package play;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Doodoo28 {

	public static void main(String[] args) {
		// 교육과정 설계
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		Queue<String> q = new LinkedList<>();
		
		for(int i=0; i<str.length(); i++) {
			
			q.add(String.valueOf(str.charAt(i)));
			
		}
		
		
		String tmp = sc.nextLine();
		
		for(int i=0; i<tmp.length(); i++) {
			if(q.isEmpty()) break;
			if(q.peek().equals(String.valueOf(tmp.charAt(i)))) {
				q.poll();
			}
		}
		
		if(q.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
