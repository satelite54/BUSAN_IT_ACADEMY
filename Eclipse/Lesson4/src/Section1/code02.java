package Section1;

import java.io.File;
import java.util.Scanner;

public class code02 {

	static Person1 [] members;
	static int n = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		members = new Person1[100]; // 배열 참조 변수 생성
		try {
			Scanner in = new Scanner(new File("input.txt"));
			while( in.hasNext()) {
				String nmString = in.next();
				String nbString = in.next();
				
				members[n] = new Person1(); // 배열 각 요소에 대한 참조변수 생성
				members[n].name = nmString;
				members[n].number = nbString;
				n++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(members[i].name + " " + members[i].number);
		}
	}
}
