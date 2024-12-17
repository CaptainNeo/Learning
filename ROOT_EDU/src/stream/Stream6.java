package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//스트림의 최종연산
//1번만 실행 스트림 요소를 모두 소모 
//
//- forEach(), anyMatch(), reduce(), findFirst(), findAny(), collect(), notMatch()
//
//
//조건검사 
//boolean allMatch (Predicate<? super T> predicate)	// 모든 요소가 조건을 만족시키면 true
//boolean anyMatch (Predicate<? super T> predicate)	// 한 요소라도 조건을 만족시키면 true
//boolean noneMatch (Predicate<? super T> predicate)	// 모든 요소가 조건을 만족시키지 않으면 true 
//
//예를 들어서 아래와 같이 
//봉급이 2억이상이 있는 직원이 있는지 확인할때? 
//		
//boolean hasSalOver2Billion = empSalList.stream().anyMatch(emp->emp.getSalary() > 200000000);
//
//
//조건에 일치하는 요소 찾기 
//findFirst()  // 첫 번째 요소를 반환 
//findAny()  // 아무거나 하나를 반환
//
//스트림의 요소를 하나씩 줄여가며 누적(accumulator)연산 수행 reduce() 도있어요 
//
//실습을 해볼게요!

public class Stream6 {
	public static void main(String[] args) {

		String[] strArr = { "강남스타일", "아가", "무궁화꽃이피었습니다", "매운갈비찜", "메로나", "타이레놀", "아파트" };

		Stream.of(strArr).forEach(System.out::println);

		System.out.println("=======================================");

		Stream.of(strArr).parallel().forEach(System.out::println);

		System.out.println("=======================================");

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		System.out.println("noEmptyStr=" + noEmptyStr);

		Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == '아').findFirst();

		System.out.println("sWord=" + sWord.get());

		// Stream<String[]>을 IntStream으로 변환
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
