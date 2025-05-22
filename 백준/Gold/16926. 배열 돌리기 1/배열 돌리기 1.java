import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dirR = new int[]{1,0,-1,0};
        int[] dirC = new int[]{0,1,0,-1};
        for(int c=0; c<C; c++) {
            for(int i=0; i<Math.min(N,M)/2; i++) {
                int startR = i;
                int startC = i;
                int dir = 0;
                int before = arr[startR][startC];
                int nextVal = 0;
                while(true) {
                    int nextR = startR + dirR[dir];
                    int nextC = startC + dirC[dir];
                    if(nextR<i || nextR>=N-i || nextC<i || nextC>=M-i) {
                        dir++;
                        if(dir==4) break;
                        else continue;
                    }
                    nextVal = arr[nextR][nextC];
                    arr[nextR][nextC] = before;
                    before = nextVal;

                    startR = nextR;
                    startC = nextC;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] i : arr) {
            for(int j : i) sb.append(j+" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }//end main
}