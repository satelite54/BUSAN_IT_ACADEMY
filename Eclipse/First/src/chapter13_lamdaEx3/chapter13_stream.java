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
		
		//자바 8 이전에는 배열 또는 컬렉션 인스턴스를 다루는 방법은 for 또는 foreach 
		//문을 돌면서 요소 하나씩을 꺼내서 다루는 방법이었습니다. 간단한 경우라면 상관없지만 
		//로직이 복잡해질수록 코드의 양이 많아져 여러 로직이 섞이게 되고, 메소드를 나눌 경우 루프를
		//여러 번 도는 경우가 발생합니다.
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);


		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> stream2 = list.stream();
		Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
		
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
		
		DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성
		
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

