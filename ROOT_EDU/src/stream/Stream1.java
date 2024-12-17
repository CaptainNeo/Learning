package stream;

import java.util.Random;
import java.util.stream.IntStream;

//��Ʈ��
//
//1. �پ��� ������ �ҽ�(�÷���, �迭)�� ǥ��ȭ�� ������� �ٷ�� ���� ��
//
//ǥ��ȭ?? -> CF �÷��������ӿ�ũ <List, Set, Map>  ������ �޶���  
//
//JDK 1,8 ���ʹ� ���� 
//
//���ĺ��ʹ� List, Set, Map, �迭 stream�� ���� �� �־����� 
//
//Stream  ->  �߰�����[n��]  -> �������� (1��)  ����� ����
//��Ʈ�������     �߰����� ������      1�� ���
//
//Stream<Integer> intStream = list.stream(); // �÷���
//Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});  // �迭
//
//
//
//
//2. ��Ʈ���� �����ϴ� ��� - �߰� ����� ���� ����
//
//1��. ��Ʈ�������
//2��. �߰����� (0 ~ n ��)
//3��. �������� (0~1��)
//
//�߰����� - �������� ��Ʈ���� ����. �ݺ������� ���밡��
//�������� - �������� ��Ʈ���� �ƴ� ����. �� �ѹ��� ���밡��(��Ʈ���� ��Ҹ� �Ҹ�)
//
//
//stream.distinct().limit(5).sorted().forEach(System.out::pritln)
//
//
//3. ��Ʈ���� Ư¡ 
//
//1.��Ʈ���� ������ �ҽ��κ��� �����͸� �б⸸�� �� ���������ʴ´� (Read Only)
//
//List<Integer> Arrays.asList(3,1,5,4,2);
//List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());;  // list�� �����ؼ� ���ο� List�� ����
//
//System.out.println(list);	// 3, 1, 5, 4, 2
//System.out.println(sortedList);  // 1, 2, 3, 4, 5

//��Ʈ���� Iterator(�÷��͸� ���������)ó�� ��ȸ���̴�(�ʿ��ϸ� �ٽ� ��Ʈ���� �����ؾ� ��)
//
//���� ���� ������ �߰������� ������� �ʴ´�. - ������ ���� 
//
//IntStream intStream = new Random().ints(1,46);  // 1~45���� ���� ��Ʈ��
//intStream.distinct().limit(6).sorted().forEach(i->System.out.print(i+", "));

//2.��Ʈ���� �۾��� ���� �ݺ����� ó���Ѵ�.

//for(String str : strList)
//	System.out.println(str); 
//
//���� �Ʒ�ó�� 
//
//stream.forEach(System.out::println);
//
//
//3. ��Ʈ���� �۾��� ���ķ� ó�� - ���Ľ�Ʈ��
//String<String> strStream = stream.of("dd", "aaa", "cc", "CC","ddd","b");
//int sum = strStream.parallel()  // ���� ��Ʈ������ ��ȯ(�Ӽ��� ����)
//                   .mapToInt(s -> s.length()).sum(); // ��� ���ڿ��� ������ ��
//�������۾��� ���� �Լ����� ���°ſ���~
//
//- �⺻�� ��Ʈ�� - IntStream, LongStream, DoubleStream
// ����ڽ� & ��ڽ��� ��ȿ���� ���ŵ�(Stream<Integer> ��� IntStream ���)
// ���ڿ� ���õ� ������ �޼��带 Stream<T>���� �� ���� ���� 
//	 {1, 2, 3} int ������ -> new Integer(1) ���������� �ٲ�� �ݴ�� ��¶� �ٲ�� �ϴ°� IntStream�� ������ ����ڽ� ��ڽ������ 
//	 �����Ͱ� �⺻���϶� IntStream�� ����°ſ��� ������ �������ٰ��ؿ� 
//	 �޼ҵ嵵 �����ΰ� �˰������� sum�� �ǰ� avg�� ����Ҽ��־��
//	 
//	 Stream<T> Ÿ���� ���� T�� ���׸� 
//	 ���⼭ ���׸��̶� �ڹٿ��� �������� Ÿ���� �Ϻ�ȭ �ϴ°��� �ǹ��ؿ� ���׸��� Ŭ������ �޼ҵ忡�� ����� ���� ������ Ÿ���� ������ �ÿ� �̸� �����ϴ� ����̿���
//	 �׷� T�� �𿡿�? �� �� �ְٴ´� �̴� type variable ������ ������ Ÿ���� �ǹ��ؿ� �� �ü� ���ڳ��� Ÿ����~

public class Stream1 {
	public static void main(String[] args) {

		IntStream intStream = new Random().ints(1, 46); // 1~45���� ���� ��Ʈ��
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + ", "));

	}
}
