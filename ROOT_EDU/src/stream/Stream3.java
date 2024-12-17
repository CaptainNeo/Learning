package stream;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//스트림의 연산 
//Stream<T> distinct()  중복을 제거 
//Stream<T> filter(Predicate<T> predicate)  조건에 맞는 요소
//
//
//
//스트림의 최종연산은 아래와 같아요 
//void forEach() 각요소에 지정된 작업 수행
//long count() 스트림의 요소의 개수 반환
//
//등등 있어요 
//
//확인해 볼가요~
//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

//몇개좀 알아볼rkdy 실습해봐요

public class Stream3 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// 스트림 자르기 - skip(), limit()

		IntStream intStream = IntStream.range(1, 10);

		intStream.skip(3).limit(5).forEach(System.out::print);
		System.out.println("======================");

		// 스트림의 요소 걸러내기 - filter(), distinct()
		IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
		intStream2.distinct().forEach(System.out::print);

		System.out.println();
		IntStream intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i % 2 == 0).forEach(System.out::print);
		System.out.println("===============================");

		// 스트림 정렬하기 sorted() // 정렬을 위해 ~~ 클래스를 정의해줄게요\
		Stream<MyCompany> companyStream = Stream.of(new MyCompany("수리", 3, 500), new MyCompany("제조", 5, 1500),
				new MyCompany("문서", 1, 120), new MyCompany("공작", 3, 400), new MyCompany("선박", 5, 2500),
				new MyCompany("화학", 7, 7500), new MyCompany("금수저", 1, 25500), new MyCompany("자영업", 2, 3500),
				new MyCompany("자동차", 4, 6500));

		companyStream.sorted(Comparator.comparing(MyCompany::getTeamLevel)).forEach(System.out::println);

	}

}

class MyCompany implements Comparable<MyCompany> {
	String teamNm;
	int teamLevel;
	int salary;

	MyCompany(String teamNm, int teamLevel, int salary) {
		this.teamNm = teamNm;
		this.teamLevel = teamLevel;
		this.salary = salary;
	}

	public String toString() {
		return String.format("[%s, %d, %d]", teamNm, teamLevel, salary);
	}

	String getTeamNm() {
		return teamNm;
	}

	int getTeamLevel() {
		return teamLevel;
	}

	int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(MyCompany o) {
		// TODO Auto-generated method stub
		return o.teamLevel - this.teamLevel; // 팀 레벨로 내림차순 기본 정렬
	}

}
