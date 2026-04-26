import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static int[] dirX = new int[] {0,0,-1,1};
    static int[] dirY = new int[] {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } //end input

        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }//end main

    public static void dfs(int row, int col, int sum, int count) {
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<4; i++) {
            int nextRow = row+dirX[i];
            int nextCol = col+dirY[i];
            if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) {
                continue;
            }
            if(!visited[nextRow][nextCol]) {
                if(count == 2) {
                    visited[nextRow][nextCol] = true;
                    dfs(row,col,sum+map[nextRow][nextCol],count+1);
                    visited[nextRow][nextCol] = false;
                }
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, sum+map[nextRow][nextCol], count+1);
                visited[nextRow][nextCol] = false;
            }
        }

    }//end dfs
}