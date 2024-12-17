package play;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient {
	int num;
	int warning;
	
	Patient(int num, int warning) {
		this.num = num;
		this.warning = warning;
	}
}

public class Doodoo29 {

	public static void main(String[] args) {
		// ¿¿±ﬁΩ«
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		Queue<Patient> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			q.add(new Patient(i, arr[i]));
		}
		
		boolean flag = true;
		int cnt = 0;
		while(flag) {
			Patient p = q.poll();
			
			int max = 0;
			for(int i=0; i<n; i++) {
				max = Math.max(max, arr[i]);
			}
			
			if(max == p.warning) {
				cnt++;
				if(m == p.num) flag = false;
				arr[p.num] = 0;
			} else {
				q.add(p);
			}
			
		}
		
		System.out.println(cnt);

	}

}
