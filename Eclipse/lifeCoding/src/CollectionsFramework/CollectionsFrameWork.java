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

//�迭���� �ٸ��� �ڵ����� ������ ������ ���� ��ų���� List�� �̿�
//�����ؾ��ϴ� �����Ͱ� �ߺ������� ������� ���� �׷��͵��� �̿��Ϸ��� Set�� �̿�
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