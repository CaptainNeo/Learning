package codingTest.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Position implements Comparable<Position> {
	int x;
	int y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Position o) {
		
		if(this.x == o.x) return this.y - o.y;
		else return this.x - o.x;

	}
	
	
}

public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Position> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			list.add(new Position(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		for(Position x : list) {
			System.out.println(x.x + " " + x.y);
		}
		
		
		

	}

}
