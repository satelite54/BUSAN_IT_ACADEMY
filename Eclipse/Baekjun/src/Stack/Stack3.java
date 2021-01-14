package Stack;
import java.util.*;

public class Stack3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = Integer.parseInt(str);
		List<Integer> list = new ArrayList<Integer>();
		
		StringBuilder sb = new StringBuilder();


		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(sc.nextLine()));
			Stack<Integer> stack = new Stack<Integer>();
			for(int j = 1; j <= n; j++) {
				if(list.get(i) >= j) {
					stack.push(j);
					System.out.println("+");
				}
				else if(list.get(i) == stack.peek()) {
					stack.pop();
					System.out.println("-");
				}
			}
		}
	}
}
