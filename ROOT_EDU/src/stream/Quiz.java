package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Quiz {

	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("빼빼로","빈츠","","바나나킥","","쿠크다스","초코파이","감자깡","새우깡");
		
		// 1. strList 리스트 안에 빈값이 몇개 있는지 출력해봐요.
		System.out.println(strList.stream().filter(i -> i.length() < 1).count());
		
		// 2. strList 리스트 안에 글자길이가 4개 이상인것만 출력해봐요.
		strList.stream().filter(i -> i.length() >= 4).forEach(System.out::println);
		
		// 3. strList 리스트 값 중에 빈값이 아닌 문자열을 리스트에 담아봐요.
		List<String> noEmptyStrings = strList.stream().filter(i -> i != "").collect(Collectors.toList());
		System.out.println(noEmptyStrings.toString());
		
		// 4. 정상회당 7개 국가 철자를 대문자로 만들고, 앞파벳  역순으로 정렬 후  국가를 출력해봐요 
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		List<String> gg = G7.stream().map(String::toUpperCase)
		           .sorted(Comparator.reverseOrder())
		           .collect(Collectors.toList());
		System.out.println(gg.toString());
		
		// 5. reduce 최종연산을 사용해서 1,2,3,4,5  sum 한값을 출력해봐요 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> total = numbers.stream().reduce((x, y) -> x + y);
		
		total.ifPresent(s -> System.out.println("sum: " + s));
		

	}

}
