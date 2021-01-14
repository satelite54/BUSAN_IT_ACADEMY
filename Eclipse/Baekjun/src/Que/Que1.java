package Que;

import java.io.*;
import java.util.*;

public class Que1 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt();
		int remove = sc.nextInt();
		sc.close();
		
		Queue<Integer> que = new LinkedList<Integer>();
		int[] nAry = new int[person];
		
		for(int i = 1; i <= person; i++) {
			que.add(i);
		}
		
		int AryCnt = 0;
		for(int i = 1; !que.isEmpty(); i++) {
			int temp = que.remove();
			if(i % remove != 0) {
				que.add(temp);
			} else {
				nAry[AryCnt] = temp;
				AryCnt++;
			}
		}
		
		System.out.print("<");
		for(int i = 0; i < nAry.length; i++) {
			if(i == nAry.length - 1) {
				System.out.print(nAry[i] + ">");
			} else {
				System.out.print(nAry[i] + ", ");
			}
		}
	}
}
