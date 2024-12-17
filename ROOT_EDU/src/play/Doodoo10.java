package play;

import java.util.ArrayList;
import java.util.Scanner;

public class Doodoo10 {

	public static void main(String[] args) {
		// 두 배열 합치기 (투포인터 문제)
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr1 = new int[n];
		
		for(int i=0; i<n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		
		int[] arr2 = new int[m];
		
		for(int i=0; i<m; i++) {
			arr2[i] = sc.nextInt();
		}
		
		// 투포인트 개념 !
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int lt = 0;
		int rt = 0;
		
		while(lt < n && rt < m) {
			
			if(arr1[lt] < arr2[rt]) {
				list.add(arr1[lt++]);
			} else {
				list.add(arr2[rt++]);
			}
			
		}
		
		// 나머지 잔재들
		while(lt < n) {
			list.add(arr1[lt++]);
		}
		
		while(rt < m) {
			list.add(arr2[rt++]);
		}
		
		for(int x : list) {
			System.out.print(x + " ");
		}

	}

}
