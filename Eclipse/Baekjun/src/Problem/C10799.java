package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class C10799 {

	public static void main(String[] args) throws IOException {
		// ��ȣ�� ������ �ٷ� ������ �������̴�.
		// ��ȣ�� ������ �������� �������� �ʴ� ��ȣ�� �踷����̴�.
		// �������� �ѹ� ��� �Ǹ� �踷����� ������ ������ �踷��� * 2�̴�.
		
		// Ž���ϸ鼭 (�������� �ٷ� )�� ������ (�� ���ϰ� �踷����� ������ (�� ���� * 2 �� �ȴ�.
		// ���� ��ġ������ �踷����� ������ ������ �������̴�.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		br.close();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		char chr = ' ';	//���� ��ȣ ������ ����
		for(int i = 0; i < str.length(); i++) {
			char tempchr = str.charAt(i);
			if(tempchr == '(') {
				stack.push(tempchr);
			} 
			if(chr == '(' && tempchr == ')') { // ������ ���
				stack.pop();
				result += stack.size() * 2; //stack.size�� �踷��� ����
			} else if(tempchr == ')') {
				stack.pop();
			}
			chr = tempchr;
		}
		System.out.println(result);
	}
}
