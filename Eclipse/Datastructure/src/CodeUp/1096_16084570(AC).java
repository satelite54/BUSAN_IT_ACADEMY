import java.util.Scanner;

public class Main {
	    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int ntotalWhiteStone = sc.nextInt();
	    String str = "";
	    for(int i = 0; i < ntotalWhiteStone * 2; i++) {
	    	str += sc.next();
	    	str += " ";
	    }
	    sc.close();
	    str = str.substring(0, str.length()-1); //문자열 자르기
	    String[] strAray = str.split(" ");
	    
	    int[][] Baduk = new int[2][ntotalWhiteStone];
	    int[][] Checkerboard = new int[20][20];
	    for(int i = 0; i < ntotalWhiteStone; i++) {
	    	Baduk[0][i] = Integer.parseInt(strAray[2 * i]);
	    	Baduk[1][i] = Integer.parseInt(strAray[2 * i + 1]);
	    	if(Checkerboard[Baduk[0][i]][Baduk[1][i]] == 1)
	    		continue;
	    	Checkerboard[Baduk[0][i]][Baduk[1][i]]++;
	    }
	    for(int i = 1; i < Checkerboard.length; i++) {
	    	for(int j = 1; j < Checkerboard.length; j++) {
	    		if(j == Checkerboard.length - 1)
	    			System.out.printf("%d\n", Checkerboard[i][j]);
	    		else
	    			System.out.printf("%d ", Checkerboard[i][j]);
	    	}
	    }
	}
}
