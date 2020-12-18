package java_temp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		// key�� value�� �����ؾ���
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");
		
		map.put("001", "kang"); //Ű ���� ���� �����Ͱ� ����ִٸ� ��ü
		
		System.out.println(map.size());
		System.out.println(map.get("001"));
		
		Set<String> set = map.keySet(); //Ű ������ ��� ������ Set �ڷᱸ���� �־���
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
