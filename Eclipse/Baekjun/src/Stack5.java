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
			
			char c = s.charAt(i);	// i 번째 문자 
			
			// 여는 괄호일 경우 스택에 push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// 닫는 소괄호 일 경우 
			else if(c == ')') {
				
				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			else if(c == ']') {
				
				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// 그 외의 경우에는 불필요한 문자들이기에 skip한다. 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
}
