package softeer.lv1;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// 근무시간 
		// 각각 월요일부터 금요일까지 출근시간이 들어오면 총 몇분일했는지를 출력 
		
		Scanner sc = new Scanner(System.in);
		
		int hh = 0;
		int mm = 0;
		
		for(int i=0; i<5; i++) {
			
			String wkTm = sc.nextLine();
			
			String[] wkInfo = wkTm.split(" ");
			
			String[] wks = wkInfo[0].split(":");
			String[] wke = wkInfo[1].split(":");
			
			int todayHh = Integer.parseInt(wke[0]) - Integer.parseInt(wks[0]);
			
			int endMm = Integer.parseInt(wke[1]);
			int strMm = Integer.parseInt(wks[1]);
			
			if(endMm < strMm) {
				todayHh -= 1;
				endMm += 60;
			}
			
			int todayMm = endMm - strMm;
			
			hh += todayHh;
			mm += todayMm;
			
			
		}
		
		System.out.println((hh*60) + mm);
		

	}

}
