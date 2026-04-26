import java.util.*;
import java.io.*;

public class Main {
    static int N,ans;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;

        dfs(0,0,1);
        System.out.println(ans);
    }//end main

    static public void dfs(int type, int r, int c) {
        if(r==N-1 && c==N-1) {
            ans++;
            return;
        }

        if(type==0) {
            if(c+1<N && map[r][c+1]==0) {
                dfs(0,r,c+1);
            }
        }
        else if(type==1) {
            if(r+1<N && map[r+1][c]==0) {
                dfs(1,r+1,c);
            }
        }
        else if(type==2) {
            if(c+1<N && map[r][c+1]==0) {
                dfs(0,r,c+1);
            }
            if(r+1<N && map[r+1][c]==0) {
                dfs(1,r+1,c);
            }
        }
        if(r+1<N && c+1<N && map[r+1][c]==0 && map[r][c+1]==0 && map[r+1][c+1]==0) {
            dfs(2,r+1,c+1);
        }
    }
}