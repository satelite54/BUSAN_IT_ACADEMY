package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Stack6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// �ܾ�(������, ����)�� ���ؿ� �ִٰ� " "�� "<"�� ������ pop�Ѵ�.
		// "<"�� ������ ">"�� ���ö����� ���ÿ� ���� �ʰ� �״�� �� ������ ����Ѵ�.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		br.close();
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder();
		
		boolean bracketFlag = false;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				bracketFlag = true;
			}
			if(str.charAt(i) == '>') {
				bracketFlag = false;
			}
			if(!bracketFlag) {
				if(str.charAt(i) == ' ' || str.charAt(i) == '<' || str.charAt(i) == '>') {
					if(str.charAt(i) == '>')
						sb.append('>');
					for(int j = 0; j < stack.size(); j++) {
						sb.append(stack.pop());
					}
				} else {
					stack.push(str.charAt(i));
				}
			} else {
				int n = stack.size();
				for(int j = 0; j < n; j++) {
					sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
			}
			if(i == str.length() - 1) {
				int n = stack.size();
				for(int j = 0; j < n; j++) {
					sb.append(stack.pop());
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
