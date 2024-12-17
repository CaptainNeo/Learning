package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//��Ʈ�� ����� - �÷��� 
//
//Collectio �������̽��� stream()���� �÷����� ��Ʈ������ ��ȯ 
//(List, Set)
//
//�ǽ��غ���

public class Stream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = list.stream(); // list�� Stream���� ��ȯ
		intStream.forEach(System.out::print);
//		intStream.forEach(System.out::print);  // <- ���� ���������ϸ� ��� ��Ҹ� �Ҹ��Ѵٶ�� �������� ��Ʈ���� ���������� ������ ����

		// �Ʒ� �迭 ��Ʈ���� ��������
		System.out.println();
		Stream<String> strStream = Stream.of("a", "b", "c");
		strStream.forEach(System.out::println);

		// �⺻�� ��Ʈ ��Ʈ��
		int[] intArr = { 1, 2, 3, 4, 5 };
		IntStream intStream2 = Arrays.stream(intArr);
		intStream2.forEach(System.out::println);

		// ��Ƽ����Ʈ��
		Integer[] intArr2 = { 1, 2, 3, 4, 5 };
		Stream<Integer> intStream3 = Arrays.stream(intArr2);
		intStream3.forEach(System.out::println);

		// ������ ������ȴ� �������� Ư¡�� ������
		IntStream intS = new Random().ints(); // <- ���� ��Ʈ��
//		intS.forEach(System.out::println);  // ���ѻ���
		intS.limit(5).forEach(System.out::println);

		// Ư�� ������ ������ ��ҷ� ���� ��Ʈ�� �����ϱ�
		IntStream intStream4 = IntStream.range(1, 5); // 1,2,3,4
		IntStream intStream5 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5

		// ���ٽ��� �ҽ��� �ϴ� ��Ʈ�� �����ϱ�
		// interate()�� ���� ��Ҹ� seed�� �ؼ� ���� ��Ҹ� ����ؿ�
		Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
		evenStream.limit(10).forEach(System.out::println);

		Stream<Integer> oneStream = Stream.generate(() -> 1);
		oneStream.limit(5).forEach(System.out::println);

		// �̿ܿ� ���� ��Ʈ������ �־�� ~ api�� ã�ƺ��ų� ���۸����ؼ� ȿ�����ΰ��� ã�� ����غ�����

	}

}
