import java.util.*;
import java.io.*;

public class Main {
    static int K, R, C, arr[][];
    static boolean visited[][][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //end input

        visited = new boolean[R][C][K+1];
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] {0,0,0,0});
        visited[0][0][0] = true;

        int[] dirR = new int[] {0, 1, 0, -1};
        int[] dirC = new int[] {1, 0, -1, 0};
        int[] likeHorseR = new int[] {2, 2, -2, -2, 1, 1, -1, -1};
        int[] likeHorseC = new int[] {-1, 1, -1, 1, -2, 2, -2, 2};

        int ans = -1;
        while(!que.isEmpty()) {
            int[] now = que.poll();
            int nowR = now[0];
            int nowC = now[1];
            int cnt = now[2];
            int dis = now[3];
            if(cnt>K) continue;

            if(nowR==R-1 && nowC==C-1) {
                ans = dis;
                break;
            }

            for(int d=0; d<4; d++) {
                int nr = nowR+dirR[d];
                int nc = nowC+dirC[d];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(arr[nr][nc]==1 || visited[nr][nc][cnt]) continue;
                que.offer(new int[] {nr,nc,cnt,dis+1});
                visited[nr][nc][cnt] = true;
            }

            if(cnt<K) {
                for(int d=0; d<8; d++) {
                    int nr = nowR+likeHorseR[d];
                    int nc = nowC+likeHorseC[d];

                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(arr[nr][nc]==1 || visited[nr][nc][cnt+1]) continue;
                    visited[nr][nc][cnt+1] = true;
                    que.offer(new int[] {nr,nc,cnt+1,dis+1});
                }
            }
        }
        System.out.println(ans);
    }//end main
}