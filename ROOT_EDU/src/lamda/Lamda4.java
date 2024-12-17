package lamda;

import java.util.function.Function;
import java.util.function.Predicate;

//Predicate의 결합
//
//- and(), or(), negate()로 두 Predicate를 하나로 결합
//
//인터페이스가 가질수 있는메서드 dafault메서드 abstrac, 추상메서드 jdk1.8이후부터 나옴 추상메서드는 월래있었고 jdk1.8이후 abstract, 추상메서드 나옴
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
//- 등가비교를 위한 Predicate의 작성에는 isEqual()를 사용(static메서드)
//
//Predicate<String> P = Predicate.isEqual(str1);	// isEqual은 static 메서드에요 
//
//Boolean result = p.test(str2);  // str1과 str2가 같은지 비교한 결과를 반환
//
//
//boolean result = Predicate.isEqual(str1).test(str2);
//
//
//
//
//실습해보아요~~

public class Lamda4 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);

		System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2)); // 2 -> "10" -> 16
		// 위처럼 람다식을 하나로 연결 할 수 있어요

		// 항등함수 예를 들어볼게요 잠깐만요 a를 넣으면 a가나와요
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

		// str1과 str2가 같은지 비교한 결과를 반환
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);

	}

}
