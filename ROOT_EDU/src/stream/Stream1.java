package stream;

import java.util.Random;
import java.util.stream.IntStream;

//스트림
//
//1. 다양한 데이터 소스(컬렉션, 배열)를 표준화된 방법으로 다루기 위한 것
//
//표준화?? -> CF 컬렉션프레임워크 <List, Set, Map>  사용법이 달랐음  
//
//JDK 1,8 부터는 통일 
//
//이후부터는 List, Set, Map, 배열 stream을 만들 수 있어졌음 
//
//Stream  ->  중간연산[n번]  -> 최종연산 (1번)  결과가 나옴
//스트림만들기     중간연산 여러번      1번 결과
//
//Stream<Integer> intStream = list.stream(); // 컬렉션
//Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});  // 배열
//
//
//
//
//2. 스트림이 제공하는 기능 - 중간 연산과 최종 연산
//
//1번. 스트림만들기
//2번. 중간연산 (0 ~ n 번)
//3번. 최종연산 (0~1번)
//
//중간연산 - 연산결과가 스트림인 연산. 반복적으로 적용가능
//최종연산 - 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)
//
//
//stream.distinct().limit(5).sorted().forEach(System.out::pritln)
//
//
//3. 스트림의 특징 
//
//1.스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지않는다 (Read Only)
//
//List<Integer> Arrays.asList(3,1,5,4,2);
//List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());;  // list를 정렬해서 새로운 List에 저장
//
//System.out.println(list);	// 3, 1, 5, 4, 2
//System.out.println(sortedList);  // 1, 2, 3, 4, 5

//스트림은 Iterator(컬렉터를 읽을때사용)처럼 일회용이다(필요하면 다시 스트림을 생성해야 함)
//
//최종 연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산 
//
//IntStream intStream = new Random().ints(1,46);  // 1~45번의 무한 스트림
//intStream.distinct().limit(6).sorted().forEach(i->System.out.print(i+", "));

//2.스트림은 작업을 내부 반복으로 처리한다.

//for(String str : strList)
//	System.out.println(str); 
//
//위를 아래처럼 
//
//stream.forEach(System.out::println);
//
//
//3. 스트림의 작업을 병렬로 처리 - 병렬스트림
//String<String> strStream = stream.of("dd", "aaa", "cc", "CC","ddd","b");
//int sum = strStream.parallel()  // 병렬 스트림으로 전환(속성만 변경)
//                   .mapToInt(s -> s.length()).sum(); // 모든 문자열의 길이의 합
//빅데이터작업을 위해 함수형언어가 나온거에요~
//
//- 기본형 스트림 - IntStream, LongStream, DoubleStream
// 오토박싱 & 언박싱의 비효율이 제거됨(Stream<Integer> 대신 IntStream 사용)
// 숫자와 관련된 유용한 메서드를 Stream<T>보다 저 많이 제공 
//	 {1, 2, 3} int 원시형 -> new Integer(1) 참조형으로 바뀌고 반대로 출력때 바뀌고 하는걸 IntStream이 빠르게 오토박싱 언박싱해줘요 
//	 데이터가 기본형일때 IntStream을 쓰라는거에요 성능이 좋아진다고해요 
//	 메소드도 숫자인거 알고있으니 sum도 되고 avg도 사용할수있어요
//	 
//	 Stream<T> 타입을 보면 T는 제네릭 
//	 여기서 제네릭이란 자바에서 데이터의 타입을 일봔화 하는것을 의미해요 제네릭은 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법이에요
//	 그럼 T가 모에요? 할 수 있겟는대 이는 type variable 임의의 참조형 타입을 의미해요 모가 올수 없자나요 타입이~

public class Stream1 {
	public static void main(String[] args) {

		IntStream intStream = new Random().ints(1, 46); // 1~45번의 무한 스트림
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + ", "));

	}
}
