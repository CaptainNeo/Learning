package codingTest.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		// ���忡�� ������ �ִ�?? ���� Ȯ������ ?? �ƽ�Ű�ڵ�ǥ�� Ȯ������ 32�� space�� 
		// ���ƴϳ� �������� ���ڿ��� �����ϸ�ǰٳ�
		// ���ڿ��� �ɰ����� �ٴ� �׷����� ���ϱ乮�ڿ��� ��� �̴´��� �װ� ���̾ƴ��� 
		
		int flagL = 0;
		
		String[] bList = sc.nextLine().split(" ");
		for(int i=0; i < bList.length; i++) {
			if(bList[i].length() > flagL) {
				flagL = bList[i].length();
				if(!m.containsKey(flagL)) {
					m.put(flagL, bList[i]);
				}
			}
		}
		
		System.out.println(m.get(flagL));
		


	}

}
