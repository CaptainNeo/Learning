package play;

import java.util.Scanner;

public class Doodoo4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();  // 캐시의  크기 
		int n = sc.nextInt();  // 작업의 개수 
		
		int[] cache = new int[s];
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 캐시미스가 날경우는 맨앞에 새로운 작업이 들어가고 전부다 밀어 맨뒤에있는애는 없어진다. 
		// 미스가 난경우는 i 는 캐시제일끝부터 돌면서 복사해 cache[i] = cache[i-1];
		
		// 캐시힛트가 날경우 해당 힛트난애는 맨앞으로 
		// 히트가 나면 히트난 index부터 cache[i] = cache[i-1]을 똑같이해 
		
		// 항상 현재 작업은 0번째에 들어가지 
		
		for(int i=0; i<n; i++) {
			int work = arr[i];
			
			// 캐시미스인지 아닌지 확인을 해야되 
			String status = "M";
			int hitIdx = 0;
			for(int j=0; j<s; j++) {
				if(cache[j] == work) {
					status = "H";
					hitIdx = j;
					break;
				}
			}
			
			if(status.equals("M")) {
				for(int j=s-1; j>=1; j--) {
					cache[j] = cache[j-1];
				}
			} else {
				// 히트낫어 캐시에 있어 이미 그럼 제일 맨앞으로 
				for(int j=hitIdx; j>=1; j--) {
					cache[j] = cache[j-1];
				}
			}
			
			cache[0] = work;
			
		}
		
		for(int x : cache) {
			System.out.print(x + " ");
		}
		

	}

}
