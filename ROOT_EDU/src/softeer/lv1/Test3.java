package softeer.lv1;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// 두 정수 a와 b를 입력받은 다음, a+b를 출력
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Case #" + (i+1) + ": " + (sc.nextInt() + sc.nextInt()));
		}
		
		
		

	}

}
