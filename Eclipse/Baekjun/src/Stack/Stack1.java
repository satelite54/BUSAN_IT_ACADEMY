package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class Stack1 {
	public static void main(String[] args) {
		// Stack에 Character 형으로 String을 넣어주다가 ' '을 만나면 스택전체 pop 
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		
		String input = "";
		String nStr = sc.nextLine();
		int n = Integer.parseInt(nStr);
		
		for(int i = 0; i < n; i++) {
			input = sc.nextLine();
			input += "\n";
			
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == ' ' || input.charAt(j) == '\n') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());						
					}
					if(input.charAt(j) == ' ') {
						sb.append(input.charAt(j));
					}
				} else {
					stack.push(input.charAt(j));
				}
				
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}
}
