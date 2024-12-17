package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Quiz {

	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("������","����","","�ٳ���ű","","��ũ�ٽ�","��������","���ڱ�","�����");
		
		// 1. strList ����Ʈ �ȿ� ���� � �ִ��� ����غ���.
		System.out.println(strList.stream().filter(i -> i.length() < 1).count());
		
		// 2. strList ����Ʈ �ȿ� ���ڱ��̰� 4�� �̻��ΰ͸� ����غ���.
		strList.stream().filter(i -> i.length() >= 4).forEach(System.out::println);
		
		// 3. strList ����Ʈ �� �߿� ���� �ƴ� ���ڿ��� ����Ʈ�� ��ƺ���.
		List<String> noEmptyStrings = strList.stream().filter(i -> i != "").collect(Collectors.toList());
		System.out.println(noEmptyStrings.toString());
		
		// 4. ����ȸ�� 7�� ���� ö�ڸ� �빮�ڷ� �����, ���ĺ�  �������� ���� ��  ������ ����غ��� 
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		List<String> gg = G7.stream().map(String::toUpperCase)
		           .sorted(Comparator.reverseOrder())
		           .collect(Collectors.toList());
		System.out.println(gg.toString());
		
		// 5. reduce ���������� ����ؼ� 1,2,3,4,5  sum �Ѱ��� ����غ��� 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> total = numbers.stream().reduce((x, y) -> x + y);
		
		total.ifPresent(s -> System.out.println("sum: " + s));
		

	}

}
