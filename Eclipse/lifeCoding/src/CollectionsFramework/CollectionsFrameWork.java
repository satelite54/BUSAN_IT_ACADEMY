package CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Collection                          			Map
// Set     			List      Queue             Sotredmap
// HashSet 			ArrayList PriorityQueue       TreeMap
// LinkedHashSet	Vector	  					Hashtable
// TreeSet			LinkedList					LinkedHashMap
//												HashMap

//배열과는 다르게 자동으로 데이터 공간을 증가 시킬려면 List를 이용
//관리해야하는 데이터가 중복적으로 저장되지 않은 그런것들을 이용하려면 Set을 이용
public class CollectionsFrameWork {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(new Computer(500, "egoing"));
		computers.add(new Computer(200, "leezche"));
		computers.add(new Computer(3233, "graphittie"));
		Iterator i = computers.iterator();
		System.out.println("before");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		Collections.sort(computers);
		System.out.println("\nafter");
		i = computers.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

class Computer implements Comparable {
	int serial;
	String owner;
	Computer(int serial, String owner) {
		this.serial = serial;
		this.owner = owner;
	}
	
	public int compareTo(Object O) {
		return this.serial - ((Computer)O).serial;
	}
	public String toString() {
		return serial+" "+owner;
	}
}