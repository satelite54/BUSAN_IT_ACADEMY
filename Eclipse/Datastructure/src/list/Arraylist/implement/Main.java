package list.Arraylist.implement;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] box = new int[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        box[1][1] = 9; // �������� ������ 9;
        int x = 0;// ���� ��ǥ x
        int y = 0;// ���� ��ǥ y
        
        for(int i = 1; i < 10; i++) { // ��ǥȹ��
            for(int j = 1; j < 10; j++) {
                if(box[i][j] == 2) {
                    y = i;
                    x = j;
                }
            }
        }
        // �ֺ� �� ���� Ž���ϰ� 0�� �ְ� x,y�� ����ؼ� ���� ����� ��������
        // �ֺ��� 0�� �ִ� ���� ��ǥ�� x,y�� �Ÿ��� ����ؼ� ���� ���� �������� �̵�
        // ���࿡ �Ÿ��� ���� ��� ���� ���� �ִ��� üũ�ϰ� ���η� �켱 �̵�
        double[] DistanceCollector = new double[4];
        int[][] pointCollector = new int[4][2];
        boolean findFeed = false;
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < 9; j++) {
                if(box[i-1][j] == 0) { // ���� �Ͽ� Ž���� ���̿��� �Ÿ� ���
                    DistanceCollector[0] = Math.sqrt((y - (i-1))*(y - (i-1)) + (x - j)*(x - j));
                    pointCollector[0][0] = i-1;
                    pointCollector[0][1] = j;
                }
                if(box[i][j-1] == 0) {
                    DistanceCollector[1] = Math.sqrt((y - i)*(y - i) + (x - (j-1))*(x - (j-1)));
                    pointCollector[1][0] = i;
                    pointCollector[1][1] = j-1;
                }
                if(box[i+1][j] == 0) {
                    DistanceCollector[2] = Math.sqrt((y - (i+1))*(y - (i+1)) + (x - j)*(x - j));
                    pointCollector[2][0] = i+1;
                    pointCollector[2][1] = j;
                }
                if(box[i][j+1] == 0) {
                    DistanceCollector[3] = Math.sqrt((y - i)*(y - i) + (x - (j+1))*(x - (j+1)));
                    pointCollector[3][0] = i;
                    pointCollector[3][1] = j+1;
                }
                int tempk = 5;
                for(int k=0;k<DistanceCollector.length;k++) { // k�� �̵��� ����
                    double minbDistance = 0;
                    if(minbDistance<DistanceCollector[k]) {
                	    minbDistance = DistanceCollector[k]; // �ּҰ�
                	    tempk = k;
                       // double degree = Math.toDegrees(Math.atan2(x, y));
                    }
                }
                switch(tempk) {
                    case 0: { //�������� �̵��� ���
                        if(box[i-1][j] == 0) {
                        // �� �����̸�
                            box[i-1][j] = 9;
                            --i;
                        }
                        else if(box[i-1][j] == 2) {
                            box[i-1][j] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 1: { //�������� �̵��� ���
                        if(box[i][j-1] == 0) {
                        // �� �����̸�
                            box[i][j-1] = 9;
                            --j;
                        }
                        else if(box[i][j-1] == 2) {
                            box[i][j-1] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 2: { //�Ʒ������� �̵��� ���
                        if(box[i+1][j] == 0) {
                        // �� �����̸�
                            box[i+1][j] = 9;
                            ++i;
                        }
                        else if(box[i+1][j] == 2) {
                            box[i+1][j] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 3: { //���������� �̵��� ���
                        if(box[i][j+1] == 0) {
                        // �� �����̸�
                            box[i][j+1] = 9;
                            ++j;
                        }
                        else if(box[i][j+1] == 2) {
                            box[i][j+1] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    default: break;
                }
                if(findFeed == true)
                    break;
            }
            if(findFeed == true)
                break;
        }
        for(int i = 0; i < box.length; i++) {
            for(int j = 0; j < box.length; j++) {
                if(j == box.length - 1) {
                    System.out.printf("%d\n", box[i][j]);
                }
                else {
                    System.out.printf("%d ", box[i][j]);
                }
            }
        }
    }
}