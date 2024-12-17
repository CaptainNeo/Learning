package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//��Ʈ���� ��������
//1���� ���� ��Ʈ�� ��Ҹ� ��� �Ҹ� 
//
//- forEach(), anyMatch(), reduce(), findFirst(), findAny(), collect(), notMatch()
//
//
//���ǰ˻� 
//boolean allMatch (Predicate<? super T> predicate)	// ��� ��Ұ� ������ ������Ű�� true
//boolean anyMatch (Predicate<? super T> predicate)	// �� ��Ҷ� ������ ������Ű�� true
//boolean noneMatch (Predicate<? super T> predicate)	// ��� ��Ұ� ������ ������Ű�� ������ true 
//
//���� �� �Ʒ��� ���� 
//������ 2���̻��� �ִ� ������ �ִ��� Ȯ���Ҷ�? 
//		
//boolean hasSalOver2Billion = empSalList.stream().anyMatch(emp->emp.getSalary() > 200000000);
//
//
//���ǿ� ��ġ�ϴ� ��� ã�� 
//findFirst()  // ù ��° ��Ҹ� ��ȯ 
//findAny()  // �ƹ��ų� �ϳ��� ��ȯ
//
//��Ʈ���� ��Ҹ� �ϳ��� �ٿ����� ����(accumulator)���� ���� reduce() ���־�� 
//
//�ǽ��� �غ��Կ�!

public class Stream6 {
	public static void main(String[] args) {

		String[] strArr = { "������Ÿ��", "�ư�", "����ȭ�����Ǿ����ϴ�", "�ſ����", "�޷γ�", "Ÿ�̷���", "����Ʈ" };

		Stream.of(strArr).forEach(System.out::println);

		System.out.println("=======================================");

		Stream.of(strArr).parallel().forEach(System.out::println);

		System.out.println("=======================================");

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		System.out.println("noEmptyStr=" + noEmptyStr);

		Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == '��').findFirst();

		System.out.println("sWord=" + sWord.get());

		// Stream<String[]>�� IntStream���� ��ȯ
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a, b) -> a + 1);
		System.out.println("count=" + count);

		int sum = intStream2.reduce(0, (a, b) -> a + b);
		System.out.println("sum=" + sum);

		OptionalInt max = intStream3.reduce(Integer::max);

		System.out.println("max=" + max.getAsInt());

		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.println("min=" + min.getAsInt());

	}

}
