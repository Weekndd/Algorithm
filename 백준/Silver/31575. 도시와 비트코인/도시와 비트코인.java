import java.io.*;
import java.util.*;

public class Main {  //백준 31575번 도시와 비트코인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[R+1][C+1];
        for(int i=1; i<=R; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=C; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        boolean[][] dp = new boolean[R+1][C+1];
        dp[1][1] = true;
        for(int i=1; i<=R; i++) {
        	for(int j=1; j<=C; j++) {
        		if(map[i][j]==0) continue;
        		if(dp[i-1][j] || dp[i][j-1]) dp[i][j] = true; 
        	}
        }
        System.out.println(dp[R][C]?"Yes":"No");
    }//end main
}