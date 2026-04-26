import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans, arr[][];
    static boolean[][] visited;
    static int[] dirR = new int[]{0,0,1,-1};
    static int[] dirC = new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        //end input
        for(int round=0; round<R; round++) {
            st = new StringTokenizer(br.readLine());
            int attackR = Integer.parseInt(st.nextToken())-1;
            int attackC = Integer.parseInt(st.nextToken())-1;
            String command = st.nextToken();

            //공격
            attack(attackR, attackC, command);
            //수비
            st = new StringTokenizer(br.readLine());
            int defenseR = Integer.parseInt(st.nextToken())-1;
            int defenseC = Integer.parseInt(st.nextToken())-1;
            visited[defenseR][defenseC] = false;
        }//end round

        StringBuilder sb = new StringBuilder();
        sb.append(ans+"\n");
        for(boolean[] i : visited) {
            for(boolean j : i) {
                if(j) sb.append("F ");
                else sb.append("S ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }//end main

    public static void attack(int r, int c, String command) {
        int direction = 0;
        if(command.equals("W")) direction = 1;
        else if(command.equals("S")) direction = 2;
        else if(command.equals("N")) direction = 3;

        int dis = 0;
        int end = visited[r][c]?0:arr[r][c];
        while(true) {
            if(end<=dis) break;

            int nr = r+dirR[direction]*dis;
            int nc = c+dirC[direction]*dis;
            if(nr<0 || nr>=N || nc<0 || nc>=M) break;
            if(visited[nr][nc]) {
                dis++;
                continue;
            }
            //end 갱신
            if(end<(arr[nr][nc])+dis) end=(arr[nr][nc])+dis;
            visited[nr][nc] = true;
            dis++;
            ans++;
        }//end while

    }//end attack
}