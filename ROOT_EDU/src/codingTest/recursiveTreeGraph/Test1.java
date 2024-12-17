package codingTest.recursiveTreeGraph;

import java.util.Scanner;

public class Test1 {
	
	public static void reculsive(int n, int trgN) {
		
		System.out.println(trgN);

		if(n == trgN) return;
		
		trgN++;
		
		reculsive(n, trgN);
		
	}

	public static void main(String[] args) {
		
		// 재귀함수 연습
		
		// 자연수 n이 입력되면 재귀함수를 이용하여 1부터 n까지 출력하는 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		reculsive(n,1);
		
		

	}

}
