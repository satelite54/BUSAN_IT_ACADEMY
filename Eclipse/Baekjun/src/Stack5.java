import java.util.*;
import java.io.*;

public class Stack5 {

	
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			Stack<Character> stackOpen = new Stack<>();
			Stack<Character> stackClose = new Stack<>();
			boolean result = false;
			String str = sc.nextLine();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(')
					stackOpen.push('(');
				if(str.charAt(i) == '[')
					stackOpen.push('[');
				try {
					if(str.charAt(i) == ')') {
						if(stackOpen.peek() == '(') {
							stackOpen.pop();
							result = true;
						}
					}
					if(str.charAt(i) == ']') {
						if(stackOpen.peek() == '[') {
							stackOpen.pop();
							result = true;
						}
					}
				} catch (Exception e) {
					result = false;
				}
				
			}
			
			if(result) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	public String NotMySolution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);	// i ��° ���� 
			
			// ���� ��ȣ�� ��� ���ÿ� push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// �ݴ� �Ұ�ȣ �� ��� 
			else if(c == ')') {
				
				// ������ ����ְų� pop�� ���Ұ� �Ұ�ȣ�� ��Ī�� �ȵǴ� ��� 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			else if(c == ']') {
				
				// ������ ����ְų� pop�� ���Ұ� ���ȣ�� ��Ī�� �ȵǴ� ��� 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// �� ���� ��쿡�� ���ʿ��� ���ڵ��̱⿡ skip�Ѵ�. 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
}
