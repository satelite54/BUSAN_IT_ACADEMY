package Section1;

import java.io.File;
import java.util.Scanner;

public class code02 {

	static Person1 [] members;
	static int n = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		members = new Person1[100]; // �迭 ���� ���� ����
		try {
			Scanner in = new Scanner(new File("input.txt"));
			while( in.hasNext()) {
				String nmString = in.next();
				String nbString = in.next();
				
				members[n] = new Person1(); // �迭 �� ��ҿ� ���� �������� ����
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
