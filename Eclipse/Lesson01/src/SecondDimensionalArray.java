import java.awt.GridBagConstraints;
import java.io.File;
import java.util.Scanner;

public class SecondDimensionalArray {

	static int n;
	static int [][] gird;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner inFileScanner = new Scanner(new File("data.txt"));
			n = inFileScanner.nextInt();
			gird = new int [n][n];
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					gird[i][j] = inFileScanner.nextInt();
			inFileScanner.close();
			
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					for(int dir = 0; dir < 8; dir++) {
						for(int len = 1; len <= n; len++) {
							int val = computeValue(x, y, dir, len);
							if(val != -1 && isPrime(val))
								System.out.println(val);
						}
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	static boolean isPrime(int a) {
		if(a % 2 == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static int computeValue(int x, int y, int dir, int len) {
		int value = 0;
		for (int i = 0; i < len; i++) {
			int digit = getDigit(x,y,dir, i);
			if(digit == -1)
				return -1;
			value = value*10 + digit;
		}
		return value;
	}
	
	static int [] offsetX = {0, 1, 1, 1, 0, -1 , -1, -1};
	static int [] offsetY = {-1, -1, 0, 1, 1, -1 , 0, -1};
	
	static int getDigit(int x, int y, int dir, int k) {
//		int newX = x, newY =y;
//		switch (dir) {
//		case 0: newY -= k;break;
//		case 1: newX += k; newY -= k; break;
//		case 2: newX += k; break;
//		case 3: newX += k; newY += k; break;
//		case 4: newY += k; break;
//		case 5: newX -= k; newY += k; break;
//		case 6: newX -= k; break;
//		case 7: newX -= k; newY -= k; break;
//		}
		
		int newX = x + k*offsetX[dir];
		int newY = y + k*offsetY[dir];
		
		if(newX < 0 || newX >= gird.length|| newY <0 || newY >= n)
			return -1;
		return gird[newX][newY];
	}
}
//            -------------
//      	  |   |   |   |
//			  -------------
//			  |   |   |   |
//			  -------------
//			  |   |   |   |
//            -------------