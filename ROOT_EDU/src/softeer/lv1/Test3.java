package softeer.lv1;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// �� ���� a�� b�� �Է¹��� ����, a+b�� ���
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Case #" + (i+1) + ": " + (sc.nextInt() + sc.nextInt()));
		}
		
		
		

	}

}
