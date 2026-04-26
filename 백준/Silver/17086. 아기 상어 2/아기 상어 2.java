import java.io.*;
import java.util.*;

public class Main {
    static int[] dirR = new int[] {0,0,1,-1,1,-1,-1,1};
    static int[] dirC = new int[] {1,-1,0,0,1,-1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<int[]> que = new LinkedList<>();
        int[][] dis = new int[R][C];
        // initial dis
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]==1) {
                    que.offer(new int[]{i, j, 0});
                    while(!que.isEmpty()) {
                        int[] now = que.poll();
                        for(int d=0; d<8; d++) {
                            int nextCnt = now[2] + 1;
                            int nextR = now[0] + dirR[d];
                            int nextC = now[1] + dirC[d];
                            if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) continue;
                            if(map[nextR][nextC]==1) continue;
                            if(dis[nextR][nextC]<=nextCnt) continue;
                            dis[nextR][nextC] = nextCnt;
                            que.offer(new int[]{nextR, nextC, nextCnt});
                        }
                        
                    }
                    
                }//end if

            } //end j for
        }//end i for
        int res = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]==1) continue;
                res = dis[i][j] > res ? dis[i][j] : res;
            }
        }
        System.out.println(res);
    }
}