package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyRectangleMain {

	static MyRectangle [] rects;
	static int n = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rects = new MyRectangle [100];
//		�迭�� ũ�� ����
		try {
			Scanner in = new Scanner(new File("data.txt"));
			
			while(in.hasNext()) {
				rects[n] = new MyRectangle();
//				Ŭ���� �迭 ���� ������ ���� �߱� ������ �迭 ������ ���� �������� ��ü ���� �ؾ��Ѵ�.
				rects[n].p1 = new Mypoint();
				rects[n].p1.X = in.nextInt();
				rects[n].p1.Y = in.nextInt();
				rects[n].width = in.nextInt();
				rects[n].height = in.nextInt();
				n++;
			}

			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		
	}
	
	private static void bubbleSort() {
		for(int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(calcArea(rects[j]) > calcArea(rects[j + 1])) {
					MyRectangle tmp = rects[j];
					rects[j] = rects[j + 1];
					rects[j + 1] = tmp;
				}
			}
		}
	}
	public static int calcArea(MyRectangle r) {
		return r.width * r.height;
	}
}
