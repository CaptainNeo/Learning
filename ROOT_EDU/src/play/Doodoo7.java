package play;

import java.util.Scanner;

public class Doodoo7 {

	public static void main(String[] args) {
		
		// ���ڿ� ���� 
		
		// 2������ ����� # -> 1 , * -> 0 
		// 2������ 10���� ȭ��Ų�� �׷� ���ڰ� ������ �� ĳ���Ͱ� ���ڴ� 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		String str = sc.nextLine();
		
		String answer = "";
		
		for(int i=0; i<n; i++) {
			String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
			int num = Integer.parseInt(tmp, 2);
			answer += (char) num;
			str = str.substring(7);
		}
		
		System.out.println(answer);

	}

}
