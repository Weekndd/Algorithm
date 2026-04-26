import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D, originMap[][], maxScore;

    static int[] dirR = new int[]{0,-1,0};
    static int[] dirC = new int[]{-1,0,1};
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        originMap = new int[N+1][M];
        visited = new boolean[M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end input
        combination(0,0);
        System.out.println(maxScore);
    }//end main
    public static void combination(int start, int cnt) {
        if(cnt==3) {
            int score = startGame(visited);
            maxScore = Math.max(score, maxScore);
            return;
        }
        for(int i=start; i<M; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            combination(i+1,cnt+1);
            visited[i] = false;
        }
    }
    public static int startGame(boolean[] bowman) {
        int score = 0;

        int[][] map = new int[N+1][M];
        for(int r=0; r<N; r++) {
            nextStage(r, bowman, map);
            for(int i=0; i<M; i++) {
                if(map[N][i]!=2) continue;
                Queue<int[]> que = new LinkedList<>();
                boolean[][] check = new boolean[N+1][M];
                que.offer(new int[]{N,i,0}); //r, c, dis
                check[N][i] = true;
                loop:
                while(!que.isEmpty()) {
                    int[] now = que.poll();
                    if(now[2]>=D) continue;
                    for(int d=0; d<3; d++) {
                        int nr = now[0]+dirR[d];
                        int nc = now[1]+dirC[d];
                        if(nr<0 || nr>N || nc<0 || nc>=M) continue;
                        if(map[nr][nc]==2 || check[nr][nc]) continue;
                        if(map[nr][nc]==1 ||map[nr][nc]==9 ) {
                            map[nr][nc] = 9;
                            break loop; //해당 궁수턴 종료
                        }
                        que.offer(new int[] {nr,nc,now[2]+1});
                        check[nr][nc] = true;
                    }
                }//end while
            }//모든 궁수 활쏘기 턴 종료

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j]==9) {
                        score++;
                        map[i][j] = 0;
                    }
                }
            }
        }//모든 라운드 끝
        return score;
    }
    public static void nextStage(int round, boolean[] bowman, int[][] newMap) {
        if(round==0) {//첫 라운드일 경우 originMap반환
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    newMap[i][j] = originMap[i][j];
                }
            }
        }
        else {
            //적 앞으로 이동
            for(int i=N-2; i>=0; i--) {
                for(int j=0; j<M; j++) {
                    newMap[i+1][j] = newMap[i][j];
                }
            }
            Arrays.fill(newMap[0],0);

        }
        for(int i=0; i<M; i++) {
            if(bowman[i]) newMap[N][i] = 2;
        }
    }//end move
}