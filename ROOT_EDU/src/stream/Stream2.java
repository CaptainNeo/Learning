package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//스트림 만들기 - 컬렉션 
//
//Collectio 인터페이스의 stream()으로 컬렉션을 스트림으로 변환 
//(List, Set)
//
//실습해봐요

public class Stream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = list.stream(); // list를 Stream으로 변환
		intStream.forEach(System.out::print);
//		intStream.forEach(System.out::print);  // <- 오류 최종연산하면 모든 요소를 소모한다라는 개념으로 스트림이 닫혀버려서 오류가 나요

		// 아래 배열 스트림도 만들어봐요
		System.out.println();
		Stream<String> strStream = Stream.of("a", "b", "c");
		strStream.forEach(System.out::println);

		// 기본형 인트 스트림
		int[] intArr = { 1, 2, 3, 4, 5 };
		IntStream intStream2 = Arrays.stream(intArr);
		intStream2.forEach(System.out::println);

		// 인티저스트림
		Integer[] intArr2 = { 1, 2, 3, 4, 5 };
		Stream<Integer> intStream3 = Arrays.stream(intArr2);
		intStream3.forEach(System.out::println);

		// 이전에 말씀드렸던 지연연산 특징좀 볼가요
		IntStream intS = new Random().ints(); // <- 무한 스트림
//		intS.forEach(System.out::println);  // 무한생성
		intS.limit(5).forEach(System.out::println);

		// 특정 범위의 정수를 요소로 갖는 스트림 생성하기
		IntStream intStream4 = IntStream.range(1, 5); // 1,2,3,4
		IntStream intStream5 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5

		// 람다식을 소스로 하는 스트림 생성하기
		// interate()는 이전 요소를 seed로 해서 다음 요소를 계산해요
		Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
		evenStream.limit(10).forEach(System.out::println);

		Stream<Integer> oneStream = Stream.generate(() -> 1);
		oneStream.limit(5).forEach(System.out::println);

		// 이외에 많은 스트림들이 있어요 ~ api를 찾아보거나 구글링을해서 효율적인것을 찾아 사용해보세요

	}

}
