package codingTest.string;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();  // ���ڸ� �а� ���๮�ڴ� ���г�!!
		
		// ���ڿ��� ���� �ð����⵵�� ����� �ʾҾ� ���� �����ص� �ǰٳ� �׷� ��� �ڷ� �����ų�..
		
		sc.nextLine();  // ���๮�ڸ� �Һ��Ͽ� ���۸� ����.  // ���๮�ڱ��� ����
		
		for(int i=0; i < n; i++) {
			String str = sc.nextLine();
			
			String answer = "";
			
			for(int l=str.length()-1; l >= 0; l-- ) {
				answer += str.charAt(l);
			}
			
			System.out.println(answer);
			
			// �Ǵ� StringBuffer ���
//			StringBuffer sb = new StringBuffer(str);
//			sb.reverse();
			
			
		}

	}

}

