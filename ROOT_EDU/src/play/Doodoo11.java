package play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Doodoo11 {

	public static void main(String[] args) {
		// ������� ���ϱ� 
		// �� ��̸� �������� lt�� ��� rt�� �ø��� ������ �� �ϳ��� ������ ���� ������� ã�°Ŵϰ�
		
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
