package play;

import java.util.Scanner;

public class Doodoo13 {

	public static void main(String[] args) {
		// ���� �κм���
		 Scanner sc = new Scanner(System.in);
		 
		 int n = sc.nextInt();
		 int m = sc.nextInt();
		 int[] arr = new int[n];
		 
		 for(int i=0; i<n; i++) {
			 arr[i] = sc.nextInt();
		 }
		 
		 int lt = 0;
		 int sum = 0;
		 int answer = 0;
		 
		 for(int rt=0; rt<n; rt++) {
			 sum += arr[rt];
			 if(sum == m) answer++;
			 else if(sum > m) {
				 while(sum > m) {
					 sum -= arr[lt++];
					 if(sum == m) answer++;
				 }
			 }
		 }
		 
		 System.out.println(answer);

	}

}
