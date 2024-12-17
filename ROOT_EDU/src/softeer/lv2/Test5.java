package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Test5 {
	
	private static int sHour;
	private static int eHour;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// [21�� ������ ��ȸ ����] ȸ�ǽ� ���� �籸�� 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, boolean[]> map = new TreeMap<>();
		
		// ȸ�ǽ� ���� 
		for(int i=0; i<n; i++) {
			map.put(br.readLine(), new boolean[9]);
		}
		
		// ������ ���ִ� ȸ�ǽ� �ð� üũ 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String mr = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			boolean[] tTable = map.get(mr);
			for(int hour=start-9; hour<end-9; hour++){
				tTable[hour] = true;
			}
		}
		
		StringBuilder allSb = new StringBuilder();
		sb = new StringBuilder();
		int hipen = 0;
		
		for(String roomNm : map.keySet()) {
			
			hipen++;
			
			allSb.append("Room ").append(roomNm).append(":\n");
			
			// ȸ�ǽ� �ð��� ��븦 Ȯ���Ϸ� ���� 
			int cnt = 0;
			boolean sc = false;  // ���డ���ѽð� Ȯ�� 
			sHour = 0;
			eHour = 0;
			sb.setLength(0);
			boolean[] rs = map.get(roomNm);
			
			for(int i=0; i<9; i++) {
				
				if(!rs[i]) {	// ������ ������ �ð�
					if(!sc) {
						sc = true;
						sHour = i;
						eHour = i + 1;
						cnt++;
						if(eHour == 9) sbAppend();
					} else {
						eHour++;
						if(eHour == 9) sbAppend();
					}
				} else {  // ������ ���ִ� �ð� 
					if(sc) {
						sc = false;
						sbAppend();
					}
				}
				
			}// end for boolean process
			
			if(cnt == 0) allSb.append("Not available\n");
			else allSb.append(cnt).append("  available:\n");
			allSb.append(sb);
			if(hipen <= n-1) allSb.append("-----\n");
					
					
			
		}// end for loop
		
		
		System.out.println(allSb);

	}
	
	public static void sbAppend() {
		if(sHour == 0) sb.append("0").append(sHour + 9).append("-").append(eHour + 9).append("\n");
		else sb.append(sHour + 9).append("-").append(eHour + 9).append("\n");
	}

}
