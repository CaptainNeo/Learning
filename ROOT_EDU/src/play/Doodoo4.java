package play;

import java.util.Scanner;

public class Doodoo4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();  // ĳ����  ũ�� 
		int n = sc.nextInt();  // �۾��� ���� 
		
		int[] cache = new int[s];
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// ĳ�ù̽��� ������ �Ǿտ� ���ο� �۾��� ���� ���δ� �о� �ǵڿ��ִ¾ִ� ��������. 
		// �̽��� ������ i �� ĳ�����ϳ����� ���鼭 ������ cache[i] = cache[i-1];
		
		// ĳ����Ʈ�� ����� �ش� ��Ʈ���ִ� �Ǿ����� 
		// ��Ʈ�� ���� ��Ʈ�� index���� cache[i] = cache[i-1]�� �Ȱ����� 
		
		// �׻� ���� �۾��� 0��°�� ���� 
		
		for(int i=0; i<n; i++) {
			int work = arr[i];
			
			// ĳ�ù̽����� �ƴ��� Ȯ���� �ؾߵ� 
			String status = "M";
			int hitIdx = 0;
			for(int j=0; j<s; j++) {
				if(cache[j] == work) {
					status = "H";
					hitIdx = j;
					break;
				}
			}
			
			if(status.equals("M")) {
				for(int j=s-1; j>=1; j--) {
					cache[j] = cache[j-1];
				}
			} else {
				// ��Ʈ���� ĳ�ÿ� �־� �̹� �׷� ���� �Ǿ����� 
				for(int j=hitIdx; j>=1; j--) {
					cache[j] = cache[j-1];
				}
			}
			
			cache[0] = work;
			
		}
		
		for(int x : cache) {
			System.out.print(x + " ");
		}
		

	}

}
