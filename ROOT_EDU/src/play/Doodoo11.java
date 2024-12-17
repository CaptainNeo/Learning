package play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Doodoo11 {

	public static void main(String[] args) {
		// 공통원소 구하기 
		// 한 어레이를 기준으로 lt로 잡고 rt를 늘리는 식으로 해 하나만 끝내면 되지 공통원소 찾는거니간
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		
		for(int i=0; i<n; i++) arr1[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		
		for(int i=0; i<m; i++) arr2[i] = sc.nextInt();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int lt = 0;
		int rt = 0;
		
		while(lt < n && rt < m) {
			if(arr1[lt] == arr2[rt]) {
				list.add(arr1[lt]);
				lt++;
				rt++;
			} else if(arr1[lt] < arr2[rt]) {
				lt++;
			} else {
				rt++;
			}
		}
		
		
		for(int x : list) System.out.print(x + " ");

	}

}
