package softeer.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test4 {

	public static void main(String[] args) {
		// [21년 재직자 대회 예선] 회의실 예약
		// 09 ~ 18
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		Map<String, boolean[]> map = new TreeMap<>();
		
		for(int i=0; i<n; i++) {
			String roomNm = sc.nextLine();
			map.put(roomNm, new boolean[25]);
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		
		for(int i=0; i<m; i++) {
			boolean[] sch = map.get(sc.next());
			int s = sc.nextInt() + 1;
			int e = sc.nextInt() + 1;
			
			for(int k=s; k<=e; k++) {
				sch[k] = true;
			}
		}

		
		int hipen = keySet.size()-1;
		
		
		for(String k : keySet) {
			boolean flag = true;
			StringBuilder sb = new StringBuilder();
			StringBuilder bb = new StringBuilder();
			sb.append("Room " + k + ":" + "\n");
//			System.out.println("Room " + k + ":");
			
			boolean[] time = map.get(k);
			
			for(int i=10; i<=19; i++) {
				if(time[i] == false) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				sb.append("Not available\n");
//				System.out.println("Not available");
			} else {
				// 회의가능한 시간을 출력 
				
				int available = 0;
//				String tmp = "";
				for(int i=10; i<=19; i++) {
					if(time[i] == true) continue;
					
					available++;
					if(i == 10) {
						bb.append(String.format("%02d", i-1));
//						tmp += String.format("%02d", i-1);
					} else {
						bb.append(String.format("%02d", i-2));
//						tmp += String.format("%02d", i-2);
					}
					
					for(int h=i; h<=19; h++) {
						if(time[h] == true) {
							bb.append("-");
							bb.append(String.format("%02d", h-1));
							bb.append("\n");
//							tmp += "-";
//							tmp += String.format("%02d", h-1);
//							tmp += "\n";
							break;
						} else {
							time[h] = true;
							if(h == 19) {
								bb.append("-18\n");
//								tmp += "-18\n";
							}
						}
					}
					
					
				}
				
				sb.append(available + " available:\n");
				sb.append(bb);
//				System.out.println(sb);
//				System.out.println(available + " available:");
//				System.out.print(tmp);
				
				
			}
			
			if(hipen != 0)
				sb.append("-----\n");
//				System.out.println("-----");
				
			System.out.print(sb);
			
			hipen--;
			
		}

	}

}
