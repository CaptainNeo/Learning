package codingTest.sortingAndSearching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {
	
	static int[] arr, tmp;
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// �������� �˰��� �̰� ���� ���� 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		tmp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		merge_sort(1, n);
		
		for(int i=1; i<=n; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();
		bw.close();

	}
	
	public static void merge_sort(int s, int e) {
		
		if(e-s < 1) {
			return;
		}
		
		int m = s + (e-s) / 2;
		
		merge_sort(s, m);
		merge_sort(m+1, e);
		
		for(int i=s; i<=e; i++) {
			tmp[i] = arr[i];
		}
		
		int k = s;
		int idx1 = s;
		int idx2 = m+1;
		
		// �α׷��� �����ϴ� ���� 
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
		
		// ���ʱ׷��� �����ִ°� ���� 
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

}
