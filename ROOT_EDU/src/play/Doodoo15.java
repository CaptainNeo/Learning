package play;

import java.util.Scanner;

public class Doodoo15 {

	public static void main(String[] args) {
		// ���ӵ� �ڿ����� �� 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		int cnt = 1;
		n--;
		while(n>0) {
			cnt++;
			n = n-cnt;
			if(n%cnt == 0) answer++;
		}
		
		System.out.println(answer);

	}

}
