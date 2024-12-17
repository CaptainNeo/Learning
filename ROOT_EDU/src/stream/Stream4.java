package stream;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

//�߰����� �̾ �غ��Կ� 
//
//
//map() -> ��ȯ
//peek() -> forEach�� ��������� �߰����� 
//flatMap -> ��ȯ   ��Ʈ�� -> ��Ʈ������ ��ȯ
//
//map�� �Ʒ��� ���ƿ� 
//Stream<T> -> Stream<R>
//
//�ǽ��غ��Կ� ~

public class Stream4 {
	public static void main(String[] args) {

		File[] fileArr = { new File("Ex1.txt"), new File("Ex1.exc"), new File("Ex1.pptx"), new File("Ex1.hwp"),
				new File("Ex1.jpeg"), new File("Ex1") };

		Stream<File> fileStream = Stream.of(fileArr);

		// map()���� Stream<File>�� Stream<String>���� ��ȯ
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);

		fileStream = Stream.of(fileArr); // ��Ʈ���� �ٽ� ����

		fileStream.map(File::getName).filter(s -> s.indexOf(".") != -1) // Ȯ���ڰ� ���� ���� ����
//			.peek(s -> System.out.printf("filename=%s%n", s))
				.map(s -> s.substring(s.indexOf(".") + 1)) // Ȯ���ڸ� ����
//			.peek(s -> System.out.printf("extenssion=%s%n", s))
				.map(String::toUpperCase) // ��� �빮�ڷ� ��ȯ
				.distinct() // �ߺ�����
				.forEach(System.out::println);

		System.out.println();

		// flatMap ���Կ�
		Stream<String[]> strArrStream = Stream.of(new String[] { "aaaa", "bbb", "cccc" },
				new String[] { "AAA", "BBB", "CCC" });

		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

		strStream.map(String::toUpperCase).distinct().sorted().forEach(System.out::println);

		System.out.println();

		String[] lineArr = { "�ȳ��ϼ��� ����   ���ε�   �Դϴ�.", "���ϸ��� ���� ���ε� �Ծ��" };

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) // ���Խ� split �ϳ��̻��ǰ���
				.distinct().sorted().forEach((s) -> System.out.println(s));

	}
}
