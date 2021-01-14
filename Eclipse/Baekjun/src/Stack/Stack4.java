package Stack;
import java.util.*;
import java.io.*;
public class Stack4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
//		sc.nextLine();
		// B�� pop
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stack1 = new Stack<Integer>();
		stack.push(' ');
		stack.pop();
		
		stack1.push(1);
		int na = stack1.pop();
		
		1 2 3 4 5
		
		5 4 3 2 1
		
		
		5
		4
		3
		2
		1
		
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		
		int Coser = str.length();

		while(n --> 0) {
			String Order = br.readLine();
			if(Order.charAt(0) == 'P') {
				int popCnt = stack.size() - Coser;
				StringBuilder sbtemp = new StringBuilder();
				while (popCnt --> 0) {
					sbtemp.append(stack.pop());	
				}
				stack.push(Order.charAt(2));
				int pushCnt = sbtemp.length();
				while (pushCnt --> 0) {
					stack.push(sbtemp.toString().charAt(pushCnt));
				}
				Coser++;
			}
			if(Order.charAt(0) == 'L') {
				if(Coser != 0)
					Coser--;
			}
			if(Order.charAt(0) == 'B') {
				if(Coser != 0) {
					int popCnt = stack.size() - Coser;
					StringBuilder sbtemp = new StringBuilder();
					while (popCnt --> 0) {
						sbtemp.append(stack.pop());	
					}
					stack.pop();
					int pushCnt = sbtemp.length();
					while (pushCnt --> 0) {
						stack.push(sbtemp.toString().charAt(pushCnt));
					}
					Coser--;
				}
			}
			if(Order.charAt(0) == 'D') {
				if(Coser != stack.size()) {
					Coser++;
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public void NotMyCode() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();
        
		//ó�� Ŀ���� ������ �� �ڿ��� �����ϱ� ������ ���� ���ÿ� �ʱ� ���ڸ� ��� �־��� (ex. abc|)
		String[] arr = str.split("");
		for(String s : arr) { //Enhanced For Loop ��� 
			leftSt.push(s); 
		}
		
		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			//StringTokenizer st = new StringTokenizer(reader.readLine());
			//String c = st.nextToken();
			
			switch(c) {
			case 'L':
				if(!leftSt.isEmpty())
					rightSt.push(leftSt.pop());

				break;
			case 'D':
				if(!rightSt.isEmpty())
					leftSt.push(rightSt.pop());

				break;
			case 'B':
				if(!leftSt.isEmpty()) {
					leftSt.pop();
				}
				break;
			case 'P':
				char t = command.charAt(2);
				leftSt.push(String.valueOf(t));
				//leftSt.push(st.nextToken());

				break;
			default:
				break;
			}
		}
        
		//Stack�� LIFO �����̱� ������
		//���� ���ÿ� �ִ� �����͵��� ��� ���������� �ű� �ڿ� �����ʿ� �ִ� ��� ������ ����Ѵ�.
		while(!leftSt.isEmpty())
			rightSt.push(leftSt.pop());
		
		while(!rightSt.isEmpty())
			bw.write(rightSt.pop());
		
		bw.flush();
		bw.close(); 
	}
}
