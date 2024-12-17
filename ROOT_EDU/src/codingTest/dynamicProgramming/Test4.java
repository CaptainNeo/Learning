package codingTest.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
	int a;  // ����
	int h;	// ����
	int w;  // ����
	
	Brick(int a, int h, int w) {
		this.a = a;
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.a - this.a;
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		
		// ���� ���� ž �ױ�  ������ �ٽ��� ���̷� ���������ؼ� �����ؾߵȴ�. ���Ը� üũ�ϸ�� ������������ �� ���ϰ� ���Դ´� �ٽ��� ���� 
		// ������ȹ����� �������� �ɰ��� Ǫ�°ž� 
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Brick> b = new ArrayList<Brick>();
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int h = sc.nextInt();
			int w = sc.nextInt();
			b.add(new Brick(a,h,w));
		}
		
		int[] dy = new int[n];
		
		Collections.sort(b);
		
		dy[0] = b.get(0).h;
		
		// ù��°�� ���������� ����������� �ִ� ���� ���� ����
		for(int i=1; i<n; i++) {
			Brick curBrick = b.get(i);
			int maxHeight = 0;
			for(int j=i-1; j>=0; j--) {
				Brick bfBrick = b.get(j);
				if(curBrick.w < bfBrick.w && dy[j] > maxHeight) {
					maxHeight = dy[j];
				}
			}
			dy[i] = curBrick.h + maxHeight;
		}
		
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dy[i]);
		}
		
		System.out.println(answer);
		
		
		

	}

}
