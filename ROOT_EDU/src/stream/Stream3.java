package stream;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//��Ʈ���� ���� 
//Stream<T> distinct()  �ߺ��� ���� 
//Stream<T> filter(Predicate<T> predicate)  ���ǿ� �´� ���
//
//
//
//��Ʈ���� ���������� �Ʒ��� ���ƿ� 
//void forEach() ����ҿ� ������ �۾� ����
//long count() ��Ʈ���� ����� ���� ��ȯ
//
//��� �־�� 
//
//Ȯ���� ������~
//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

//��� �˾ƺ�rkdy �ǽ��غ���

public class Stream3 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// ��Ʈ�� �ڸ��� - skip(), limit()

		IntStream intStream = IntStream.range(1, 10);

		intStream.skip(3).limit(5).forEach(System.out::print);
		System.out.println("======================");

		// ��Ʈ���� ��� �ɷ����� - filter(), distinct()
		IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
		intStream2.distinct().forEach(System.out::print);

		System.out.println();
		IntStream intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i % 2 == 0).forEach(System.out::print);
		System.out.println("===============================");

		// ��Ʈ�� �����ϱ� sorted() // ������ ���� ~~ Ŭ������ �������ٰԿ�\
		Stream<MyCompany> companyStream = Stream.of(new MyCompany("����", 3, 500), new MyCompany("����", 5, 1500),
				new MyCompany("����", 1, 120), new MyCompany("����", 3, 400), new MyCompany("����", 5, 2500),
				new MyCompany("ȭ��", 7, 7500), new MyCompany("�ݼ���", 1, 25500), new MyCompany("�ڿ���", 2, 3500),
				new MyCompany("�ڵ���", 4, 6500));

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
		return o.teamLevel - this.teamLevel; // �� ������ �������� �⺻ ����
	}

}
