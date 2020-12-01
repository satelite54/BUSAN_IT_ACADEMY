package chapter13_lamdaEx3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class chapter13_stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ڹ� 8 �������� �迭 �Ǵ� �÷��� �ν��Ͻ��� �ٷ�� ����� for �Ǵ� foreach 
		//���� ���鼭 ��� �ϳ����� ������ �ٷ�� ����̾����ϴ�. ������ ����� ��������� 
		//������ ������������ �ڵ��� ���� ������ ���� ������ ���̰� �ǰ�, �޼ҵ带 ���� ��� ������
		//���� �� ���� ��찡 �߻��մϴ�.
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);


		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> stream2 = list.stream();
		Stream<String> parallelStream = list.parallelStream(); // ���� ó�� ��Ʈ��
		
		Stream<String> builderStream = 
				  Stream.<String>builder()
				    .add("Eric").add("Elena").add("Java")
				    .build(); // [Eric, Elena, Java]
		
		Stream<String> generatedStream = 
				  Stream.generate(() -> "gen").limit(5); // [el, el, el, el, el]
		
		Stream<Integer> iteratedStream = 
				  Stream.iterate(30, n -> n + 2).limit(5); // [30, 32, 34, 36, 38]
		
		IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
		LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
		
		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
		
		DoubleStream doubles = new Random().doubles(3); // ���� 3�� ����
		
		IntStream charsStream = 
				  "Stream".chars(); // [83, 116, 114, 101, 97, 109]
		
		Stream<String> stringStream = 
				  Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
				  // [Eric, Elena, Java]
		
		try {
			Stream<String> lineStream = 
					  Files.lines(Paths.get("file.txt"), 
					              Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

