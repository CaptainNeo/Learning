package lamda;

import java.util.function.Function;
import java.util.function.Predicate;

//Predicate�� ����
//
//- and(), or(), negate()�� �� Predicate�� �ϳ��� ����
//
//�������̽��� ������ �ִ¸޼��� dafault�޼��� abstrac, �߻�޼��� jdk1.8���ĺ��� ���� �߻�޼���� �����־��� jdk1.8���� abstract, �߻�޼��� ����
//
//
//Predicate<Integer> p = i -> i < 100;
//Predicate<Integer> q = i -> i < 200;
//Predicate<Integer> r = i -> i%2 == 0;
//
//Predicate<Integer> notP = p.negate();	// i >= 100 
//Predicate<Integer> all = notP.and(q).or(r);   // 100 <= i  && i < 200 || i%2==0
//Predicate<Integer> all2 = notP.and(q.or(r));	// 100 <= i && (i <200 || i%2==0)
//
//System.out.println(all.test(2));		// true
//System.out.println(all2.test(2));		// false
//
//- ��񱳸� ���� Predicate�� �ۼ����� isEqual()�� ���(static�޼���)
//
//Predicate<String> P = Predicate.isEqual(str1);	// isEqual�� static �޼��忡�� 
//
//Boolean result = p.test(str2);  // str1�� str2�� ������ ���� ����� ��ȯ
//
//
//boolean result = Predicate.isEqual(str1).test(str2);
//
//
//
//
//�ǽ��غ��ƿ�~~

public class Lamda4 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);

		System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2)); // 2 -> "10" -> 16
		// ��ó�� ���ٽ��� �ϳ��� ���� �� �� �־��

		// �׵��Լ� ���� ���Կ� ��񸸿� a�� ������ a�����Ϳ�
		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("doodoo again"));

		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate(); // i >= 100

		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150)); // true

		String str1 = "doodoo";
		String str2 = "doodoo7";

		// str1�� str2�� ������ ���� ����� ��ȯ
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);

	}

}
