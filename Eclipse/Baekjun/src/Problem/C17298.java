package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class C17298 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Cnt = br.readLine().charAt(0);
		String str = br.readLine();
		
		br.close();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] nAry = new int[st.countTokens()];
		
		int n = 0;
		while(st.hasMoreTokens()) {
			nAry[n] = Integer.parseInt(st.nextToken());
			n++;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		StringBuilder sb = new StringBuilder();
		
		int[] ans = new int[nAry.length];
		
		for(int i = 1; i < Cnt; i++) {
			if(stack.empty()) {
				stack.push(i);
			}
			while (!stack.empty() && nAry[stack.peek()] < nAry[i]) {
				ans[stack.peek()] = nAry[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			ans[stack.peek()] = -1;
			stack.pop();
		}
		
		for(int i = 0; i < Cnt; i++) {
			sb.append(ans[i]);
			sb.append(' ');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public void trash() throws IOException { // ½Ã°£ÃÊ°ú¶ß´Â ÄÚµå
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Cnt = br.readLine().charAt(0);
		String str = br.readLine();
		
		br.close();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] nAry = new int[st.countTokens()];
		
		int n = 0;
		while(st.hasMoreTokens()) {
			nAry[n] = Integer.parseInt(st.nextToken());
			n++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < nAry.length - 1; i++) { // ÃÖ¾Ç(O(n^2));
			int temp = -1;
			for(int j = i; j < nAry.length - 1; j++) {
				if(nAry[i] < nAry[j + 1]) {
					temp = nAry[j + 1];
					break;
				}
			}
			sb.append(temp);
			sb.append(" ");
		}
		sb.append(-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
