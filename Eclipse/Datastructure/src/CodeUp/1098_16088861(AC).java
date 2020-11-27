import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt(); // nextInt는 개행 무시하고 다음 입력값을 
        // 받지만 nextLine은 개행이 있으면 곧바로 종료
        int n = sc.nextInt();
        int[][] ldxy = new int[n][4];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < 4; i++) {
                ldxy[j][i] = sc.nextInt(); // nosucheliment;
            }
        }
        // 막대의 좌표 획득 후 획득한 좌표로 부터 방향을 지정해 길이만
        // 큼 변경
        int[][] broad = new int[h + 1][w + 1];
        for(int i = 0; i < h + 1; i++) {
            for(int j = 0; j < w + 1; j++) {
                for(int k = 0; k < ldxy.length; k++) {
                    if(j==ldxy[k][3]&&i==ldxy[k][2]) { //x,y가 같은지 비교
                        broad[i][j] = 1;
                        if(ldxy[k][1] == 0) {
                            for(int l = 1; l < ldxy[k][0]; l++) {//가로출력
                                broad[i][j + l] = 1;
                            }
                        } else if(ldxy[k][1] == 1) {
                            for(int l = 1; l < ldxy[k][0]; l++) {//세로출력
                                broad[i + l][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(j == w - 1)
                    System.out.printf("%d\n", broad[i + 1][j + 1]);
                else
                    System.out.printf("%d ", broad[i + 1][j + 1]);
            }
        }
    }
}
