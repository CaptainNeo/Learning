package codingTest.hashmapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int lt = 0;
		
		// ∞À¡ı
		for(int rt=k-1; rt<n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			
			list.add(map.size());
			
			if(map.get(arr[lt]) -1 == 0)  {
				map.remove(arr[lt]);
				lt++;
			}
			else {
				map.put(arr[lt], map.get(arr[lt]) -1);
				lt++;
			}
			
		}
		
		for(int x : list) {
			System.out.print(x + " ");
		}
		

	}

}
