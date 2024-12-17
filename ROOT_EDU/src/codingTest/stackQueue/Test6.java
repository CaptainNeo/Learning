package codingTest.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
	    for(int i=0; i<n; i++) {
	    	q.offer(i+1);
	    }
	    
	    
	    int cnt = 0;
	    
	    while(q.size() > 1) {
	    	cnt++;
	    	if(cnt == k) {
	    		q.poll();
	    		cnt = 0;
	    	} else {
	    		int tmp = q.poll();
	    		q.offer(tmp);
	    	}
	    }
	    
	    System.out.println(q.poll());
	    

	}

}
