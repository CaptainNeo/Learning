package stream;

import java.util.Optional;
import java.util.OptionalInt;

//Optional<T>
// - 제네릭 T 타입 객체의 래퍼클래스 (Integer, Long)
// - T타입의 참조변수를 가질 수 있어요 모든 종류의 객체저장, !! 중요 NULL 도 저장
// 
// 1. null을 직접다루는것은 위험해요 null point exception이 발생할 수 있어요 
// 그래서 간접적으로 Optional을 사용해요 
// 
// 2. null을 다룬다면 null 체크를 해야하는대 if문이 필수에요 코드가 지저분해져요 
// 
// 이런문제들을 해결하기 위해 Optional을 사용해서 간접적으로 다루기 시작했어요 
// 
//Object result = getResult(); <---반환값이 하나는 null 이거나 객체겠죠?? 
//그럼 result.toStr()  이라고 했을때 null point exception이 발생하겠죠 
//
//그럼 우리는 아래와 같이 썻어요 
//if(result != null) {
//	print(result.toStr());
//}
//
//Optional에 집어넣는거에요 그래도 Optional에는 주소가 있기때문에 항상 null 이 아니에요 (ox120)
//

//Optional<T> 객체의 값 가져오기 
//- get(), orElse(), orElseGet(), orElseThrow()
//
//Optional<String> optVal = Optional.of("abc");
//String str1 = optVal.get();	// optVal에 저장된 값을 반환. null이면 예외 발생
//String str2 = optVal.orElse("")	// optVal에 저장된 값이 null일때는 ""를 반환
//String str3 = optVal.orElseGet(String::new);	// 람다식 사용가능 () -> new String()
//String str4 = optVal.orElseThrow(NullPointerException::new);		// 널이면 예외발생

//ifPresent() - Optional객체의 값이 null 이면 false, 아니면 true를 반환
//
//Optional.ofNullable(str).ifPresent(System.out::println); <-- ifPresent는 널이 아닐때만 작업수행 널이면 아무것도 안 함 

// isPresent() - Optional객체 값을 가지고 있다면 true 없다면 false   <-- ifPresent와 달리 boolean을 리턴값으로 줌 

//OptionalInt, OptionalLong, OptionalDouble   <-- 기본형 값을 감싸는 래퍼클래스를 사용할 수 있어요 성능향상으로 쓰여요 

//실습해볼게요~~

public class Stream5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = null;
//		System.out.println("arr.length="+arr.length);  <-- 에러

		int[] arr = new int[0];
		System.out.println("arr.length=" + arr.length);

		// Optional<String> opt = Optional.empty(); // 바람직하지 않음
		Optional<String> opt = Optional.empty();

		String str = "두두";
		try {
			str = opt.get();
		} catch (Exception e) {
			str = "예외 발생이에요";
		}

		System.out.println("str=" + str);

		String str2 = opt.orElse("널이에요 그래서 나를 출력할거에요"); // Optional에 저장된 값이 null이면 반환
		System.out.println("str2=" + str2);

		String str3 = opt.orElseGet(() -> new String("dsf")); // 람다식
		System.out.println("str3=" + str3);

		String str4 = opt.orElseGet(String::new).concat("dddddd"); // 메소드참조
		System.out.println("str4=" + str4);

		/////////////////////////////////////////////////////////////////////////

		Optional<String> optStr = Optional.of("abcde");
		Optional<Integer> optInt = optStr.map(String::length);
		System.out.println("optStr=" + optStr.get());
		System.out.println("optInt=" + optInt.get());

		int result1 = Optional.of("234").filter(x -> x.length() > 2).map(Integer::parseInt).get();
		System.out.println("result1=" + result1);

		int result2 = Optional.of("").filter(x -> x.length() > 0).map(Integer::parseInt).orElse(999);

		System.out.println("result2=" + result2);

		Optional.of("456").map(Integer::parseInt).ifPresent(x -> System.out.println("result3=" + x));

		OptionalInt optInt1 = OptionalInt.of(0); // 0을 저장
		OptionalInt optInt2 = OptionalInt.empty(); // 빈 객체를 생성

		System.out.println(optInt1.isPresent());
		System.out.println(optInt2.isPresent());

	}

}
