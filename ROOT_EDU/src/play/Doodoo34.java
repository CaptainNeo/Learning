package play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Doodoo34 {
	
	public static int count(int[] arr, int dist) {
		
		int endPoint = arr[0];  // ���������� ����
		int cnt = 1;  // ���� ù��°�������� �־��ٰ� ����.
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] - endPoint >= dist) {  // �̺а˻����� �ش�Ÿ���ŭ ���� ���´ٴ� ����
				cnt++;
				endPoint = arr[i];
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// ������ ���ϱ� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int lt = 1;
		int rt = arr[n-1];
		int answer = 0;
		
		while(lt<=rt) {
			
			int mid = (lt+rt) / 2;
			
			if(count(arr, mid) >= c) {
				answer = mid;
				lt = mid+1;
			} else {
				rt = mid-1;
			}
			
		}
		
		
		System.out.println(answer);
		
		

	}

}
