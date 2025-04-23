import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[R+1][C+1];
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=R; i++) {
            for(int j=0; j<=C; j++) {
                if(i==0 || i==R) map[i][j] = 0;
                else if(j==0 || j==C) map[i][j] = 0;
                else map[i][j] = 2;
            }
        }

        int r = 0;
        int c = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            //북 남 서 동
            int quater = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(quater==1) {
                r=0;
                c=length;
            }
            else if(quater==2) {
                r=R;
                c=length;
            }
            else if(quater==3) {
                r=length;
                c=0;
            }
            else if(quater==4) {
                r=length;
                c=C;
            }
            //경비원 위치 저장
            if(i<N) map[r][c] = 1;
            else {
                que.offer(new int[]{r,c,0});
                map[r][c]= 3;
            }
        }
        int sum = 0;
        int[] dirR = new int[] {-1,1,0,0};
        int[] dirC = new int[] {0,0,-1,1};
        int find = 0;
        while(find!=N) {
            int[] security = que.poll();
            for(int i=0; i<4; i++) {
                int nextR = security[0]+dirR[i];
                int nextC = security[1]+dirC[i];
                if(nextR<0 || nextR>R || nextC<0 || nextC>C) continue;
                if(map[nextR][nextC] == 2) continue;
                if(map[nextR][nextC] == 1) {
                    find++;
                    sum+=security[2]+1;
                }
                map[nextR][nextC] = 2;
                que.offer(new int[]{nextR,nextC, security[2]+1});
            }
        }
        System.out.println(sum);
    }//end main
}