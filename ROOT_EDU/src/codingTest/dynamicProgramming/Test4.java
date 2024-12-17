package codingTest.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
	int a;  // 넓이
	int h;	// 높이
	int w;  // 무게
	
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
		
		// 가장 높은 탑 쌓기  문제의 핵심은 넓이로 내림차순해서 결정해야된다. 무게만 체크하면되 이전문제보다 좀 딥하게 들어왔는대 핵심은 같아 
		// 동적계획법대로 문제들을 쪼개서 푸는거야 
		
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
		
		// 첫번째가 마지막으로 세워졌을경우 최대 높이 부터 시작
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
