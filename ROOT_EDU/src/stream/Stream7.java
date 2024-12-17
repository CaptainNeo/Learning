package stream;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//collect()�� Collectors 
//
//�Ű������� �ϴ� ��Ʈ���� �������� 
//
//Collect�� ����(collect)�� �ʿ��� �޼��带 ������ ���� �������̽�
//
//public interface Collector<T, A, R>   // T(���)�� A�� ������ ����, ����� R�� ��ȯ�ؼ� ��ȯ 
//
//CollectorŬ������ Collector�������̽��� �����س��Ҿ�� 
//
//��ȯ - mapping(), toList(), toSet(), toMap()...
//��� - averagingInt(), maxBy() 
//���ڿ����� - joining() 
//����� - reducing()
//�׷�ȭ�� ���� - grooupingBy(), partitioningBy(), collectingAndThen()
//
//
//collect() ��������
//Collector �������̽�
//Collectors: Ŭ���� Collector�� ���� �̰͸� �߾��� �ǿ� 
//
//� �۾��� �ϴ��� �˾ƺ��Կ� 
//
//��Ʈ���� �÷������� ��ȯ�ؿ� 
//toList()
//toSet()
//toMap()
//toCollection()
//
//�ᰣ �Ʒ� ��� ���°��� ��� �޼ҵ带 ȣ���ϴ��� ������ ���ð� �ǽ��� ���Կ� 
//
//List<String> names = stuStream.map(Student::getName)
//                              .collect(Collectors.toList()); // Stream<String> -> List<String>
//
//ArrayList<String> list = names.stream()
//                              .collect(Collectors.toCollection(ArrayList::new));  // Stream<String> -> ArrayList<String>
//
//
//Map<String, Person> map = personStream.collect(Collectors.toMap(p->p.getRegId(),p -> p));  // Stream<Person> -> Map<String, Person>
//
//
//�ǽ��� ���ƿ�~

public class Stream7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student[] stuArr = { new Student("��浿", true, 1, 1, 150), new Student("�ȼ���", true, 1, 1, 200),
				new Student("������", true, 1, 1, 400), new Student("�̿���", true, 1, 2, 222),
				new Student("������", false, 1, 2, 345), new Student("����", true, 1, 2, 300),
				new Student("�Լҿ�", false, 1, 3, 300), new Student("�ֹν�", true, 1, 3, 555),
				new Student("���׸�", true, 1, 3, 567), new Student("������", false, 2, 1, 345),
				new Student("�����", false, 2, 1, 123), new Student("����", false, 2, 1, 99),
				new Student("����", false, 2, 2, 8), new Student("�赿��", true, 2, 2, 0), new Student("�㰢", true, 2, 2, 7),
				new Student("������", false, 3, 1, 12), new Student("�Ŵ���", false, 3, 1, 55),
				new Student("������", false, 3, 1, 888), new Student("�ݺ���", false, 3, 2, 777),
				new Student("��ȿ��", false, 3, 2, 123), };

		System.out.println("������ �׷��� ����Կ�");
		Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale));

		List<Student> maleStudent = stuBySex.get(true);
		List<Student> femaleStudent = stuBySex.get(false);

		System.out.println("���ڱ׷����� ����Ʈ ��� ����");
		for (Student s : maleStudent)
			System.out.println(s);
		System.out.println("���ڱ׷����� ����Ʈ ��� ����");
		System.out.println();
		System.out.println("���ڱ׷����� ����Ʈ ��� ����");
		for (Student s : femaleStudent)
			System.out.println(s);
		System.out.println("���ڱ׷����� ����Ʈ ��� ����");

		System.out.println("=============�ݺ��� �׷�ȭ=============");
		Map<Integer, List<Student>> stuByBan = Stream.of(stuArr).collect(Collectors.groupingBy(Student::getBan));

		for (List<Student> s : stuByBan.values()) {
			for (Student sObj : s) {
				System.out.println(sObj);
			}
		}

		System.out.println("=================�������� �׷�ȭ===================");
		Map<Student.LEVEL, List<Student>> stuByLevel = Stream.of(stuArr).collect(Collectors.groupingBy(s -> {
			if (s.getScore() > 500)
				return Student.LEVEL.HIGH;
			else if (s.getScore() > 300)
				return Student.LEVEL.MID;
			else
				return Student.LEVEL.LOW;
		}));

		TreeSet<Student.LEVEL> keySet = new TreeSet<>(stuByLevel.keySet());

		for (Student.LEVEL key : keySet) {
			System.out.println("[[" + key + "]]");

			for (Student s : stuByLevel.get(key)) {
				System.out.println(s);
			}
			System.out.println();

		}

		System.out.println("================ �ݺ� �׷�ȭ ====================");
		Stream<Student> stuStream = Stream.of(stuArr);

		Map<Integer, List<Student>> stuByHakAndBan = stuStream.collect(Collectors.groupingBy(Student::getHak));

		for (int ban : stuByHakAndBan.keySet()) {
			System.out.println(ban + "�� �л��� �𿩶�");
			for (Student s : stuByHakAndBan.get(ban)) {
				System.out.println(s);
			}
			System.out.println();
		}

	}

}

class Student {
	String name;
	boolean isMale; // ����
	int hak; // �г�
	int ban; // ��
	int score; // ����

	Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return String.format("[%s, %s, %d�г� %d��, %3d��]", name, isMale ? "��" : "��", hak, ban, score);
	}

	enum LEVEL {
		HIGH, MID, LOW
	} // ������ �� , ��, �� �� �ܰ�� �з�

}
