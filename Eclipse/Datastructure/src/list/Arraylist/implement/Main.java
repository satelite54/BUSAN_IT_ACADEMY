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
        box[1][1] = 9; // 개미집은 무조건 9;
        int x = 0;// 먹이 좌표 x
        int y = 0;// 먹이 좌표 y
        
        for(int i = 1; i < 10; i++) { // 좌표획득
            for(int j = 1; j < 10; j++) {
                if(box[i][j] == 2) {
                    y = i;
                    x = j;
                }
            }
        }
        // 주변 네 방향 탐색하고 0이 있고 x,y를 계산해서 가장 가까운 구간으로
        // 주변에 0이 있는 곳의 좌표와 x,y의 거리를 계산해서 가장 작은 구간으로 이동
        // 만약에 거리가 같을 경우 옆에 벽이 있는지 체크하고 가로로 우선 이동
        double[] DistanceCollector = new double[4];
        int[][] pointCollector = new int[4][2];
        boolean findFeed = false;
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < 9; j++) {
                if(box[i-1][j] == 0) { // 상좌 하우 탐색후 먹이와의 거리 계산
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
                for(int k=0;k<DistanceCollector.length;k++) { // k는 이동할 방향
                    double minbDistance = 0;
                    if(minbDistance<DistanceCollector[k]) {
                	    minbDistance = DistanceCollector[k]; // 최소값
                	    tempk = k;
                       // double degree = Math.toDegrees(Math.atan2(x, y));
                    }
                }
                switch(tempk) {
                    case 0: { //위쪽으로 이동인 경우
                        if(box[i-1][j] == 0) {
                        // 빈 공간이면
                            box[i-1][j] = 9;
                            --i;
                        }
                        else if(box[i-1][j] == 2) {
                            box[i-1][j] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 1: { //왼쪽으로 이동인 경우
                        if(box[i][j-1] == 0) {
                        // 빈 공간이면
                            box[i][j-1] = 9;
                            --j;
                        }
                        else if(box[i][j-1] == 2) {
                            box[i][j-1] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 2: { //아랫쪽으로 이동인 경우
                        if(box[i+1][j] == 0) {
                        // 빈 공간이면
                            box[i+1][j] = 9;
                            ++i;
                        }
                        else if(box[i+1][j] == 2) {
                            box[i+1][j] = 9;
                            findFeed = true;
                        }
                        break;
                    }
                    case 3: { //오른쪽으로 이동인 경우
                        if(box[i][j+1] == 0) {
                        // 빈 공간이면
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