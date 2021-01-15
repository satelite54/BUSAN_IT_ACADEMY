package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
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
				result += stack.size(); //stack.size�� �踷��� ����
			}
			chr = tempchr;
		}
		System.out.println(result);
	}
	
	public void NotMySolution() {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.substring(i,i+1).equals("("))
                stack.push(i);
            else {
                if(stack.peek() == i-1) {
                    stack.pop();
                    count+=stack.size();
                }
                else {
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
	}
}
