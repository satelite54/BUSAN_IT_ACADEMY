package java_temp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		// key와 value로 지정해야함
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");
		
		map.put("001", "kang"); //키 값이 같은 데이터가 들어있다면 교체
		
		System.out.println(map.size());
		System.out.println(map.get("001"));
		
		Set<String> set = map.keySet(); //키 값들을 모두 꺼내서 Set 자료구조에 넣어줌
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
