package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class C10799 {

	public static void main(String[] args) throws IOException {
		// 괄호가 열리고 바로 닫히면 레이저이다.
		// 괄호가 열리고 닫히지만 인접하지 않는 괄호는 쇠막대기이다.
		// 레이저를 한번 쏘게 되면 쇠막대기의 개수는 생성된 쇠막대기 * 2이다.
		
		// 탐색하면서 (가나오고 바로 )가 나오면 (를 팝하고 쇠막대기의 개수는 (의 개수 * 2 가 된다.
		// 지금 위치에서의 쇠막대기의 개수는 스택의 사이즈이다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		br.close();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		char chr = ' ';	//이전 괄호 데이터 저장
		for(int i = 0; i < str.length(); i++) {
			char tempchr = str.charAt(i);
			if(tempchr == '(') {
				stack.push(tempchr);
			} 
			if(chr == '(' && tempchr == ')') { // 레이져 쏘기
				stack.pop();
				result += stack.size() * 2; //stack.size는 쇠막대기 갯수
			} else if(tempchr == ')') {
				stack.pop();
			}
			chr = tempchr;
		}
		System.out.println(result);
	}
}
