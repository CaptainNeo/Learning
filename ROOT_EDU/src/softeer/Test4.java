package softeer;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// lv1 °³Ç¥ 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			
			int tmp = sc.nextInt();
			
			String answer = "";
			
			int plusCnt = tmp/5;
			int pipeCnt = tmp%5;
			
			for(int k=0; k<plusCnt; k++) {
				answer += "++++ ";
			}
			
			for(int k=0; k<pipeCnt; k++) {
				answer += "|";
			}
			
			System.out.println(answer);
			
		}

	}

}
