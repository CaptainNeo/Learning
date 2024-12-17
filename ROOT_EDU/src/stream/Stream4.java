package stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

//중간연산 이어서 해볼게요 
//
//
//map() -> 변환
//peek() -> forEach랑 비슷하지만 중간연산 
//flatMap -> 변환   스트림 -> 스트림으로 변환
//
//map은 아래와 같아요 
//Stream<T> -> Stream<R>
//
//실습해볼게요 ~

public class Stream4 {
	public static void main(String[] args) {

		File[] fileArr = { new File("Ex1.txt"), new File("Ex1.exc"), new File("Ex1.pptx"), new File("Ex1.hwp"),
				new File("Ex1.jpeg"), new File("Ex1") };

		Stream<File> fileStream = Stream.of(fileArr);

		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);

		fileStream = Stream.of(fileArr); // 스트림을 다시 생성

		fileStream.map(File::getName).filter(s -> s.indexOf(".") != -1) // 확장자가 없는 것은 제외
//			.peek(s -> System.out.printf("filename=%s%n", s))
				.map(s -> s.substring(s.indexOf(".") + 1)) // 확장자만 추출
//			.peek(s -> System.out.printf("extenssion=%s%n", s))
				.map(String::toUpperCase) // 모두 대문자로 변환
				.distinct() // 중복제거
				.forEach(System.out::println);

		System.out.println();

		// flatMap 볼게요
		Stream<String[]> strArrStream = Stream.of(new String[] { "aaaa", "bbb", "cccc" },
				new String[] { "AAA", "BBB", "CCC" });

		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

		strStream.map(String::toUpperCase).distinct().sorted().forEach(System.out::println);

		System.out.println();

		String[] lineArr = { "안녕하세요 저는   전두두   입니다.", "매일매일 밥을 전두두 먹어요" };

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 정규식 split 하나이상의공백
				.distinct().sorted().forEach((s) -> System.out.println(s));

	}
}
