package play;

import java.util.Scanner;

public class MergeSort2 {
	
	static int[] arr, tmp;
	
	public static void merge_sort(int s, int e) {
		if( e - s < 1) return;
		
		int m = s + (e - s) / 2;
		
		merge_sort(s, m);
		merge_sort(m+1, e);
		
		for(int i=s; i<=e; i++) {
			tmp[i] = arr[i];
		}
		
		int k = s;
		int idx1 = s;
		int idx2 = m+1;
		
		while(idx1 <= m && idx2 <= e) {
			if(tmp[idx1] > tmp[idx2]) {
				arr[k] = tmp[idx2];
				k++;
				idx2++;
			} else {
				arr[k] = tmp[idx1];
				k++;
				idx1++;
			}
		}
		
		while(idx1 <= m) {
			arr[k] = tmp[idx1];
			k++;
			idx1++;
		}
		
		while(idx2 <= e) {
			arr[k] = tmp[idx2];
			k++;
			idx2++;
		}
				
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n+1];
		tmp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		merge_sort(1, n);
		
		for(int i=1; i<=n; i++) {
			System.out.println(arr[i]);
		}		
				

	}

}
