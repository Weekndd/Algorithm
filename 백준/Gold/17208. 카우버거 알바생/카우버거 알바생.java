import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int  N = Integer.parseInt(st.nextToken()); //주문 수
    	int  M = Integer.parseInt(st.nextToken()); //버거 수
    	int  K = Integer.parseInt(st.nextToken()); //감튀 수
    	
    	int[][] order = new int[N+1][2];
    	for(int i=1; i<=N ; i++) {
    		st = new StringTokenizer(br.readLine());
    		int bugger = Integer.parseInt(st.nextToken());
    		int fries = Integer.parseInt(st.nextToken());
    		order[i][0] = bugger;
    		order[i][1] = fries;
    	}
    	int[][][] dp = new int[N+1][M+1][K+1];
    	for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0; // 초기 상태
        
    	for(int i=1; i<=N; i++) { //주문
    		int orderBugger = order[i][0];
    		int orderFries = order[i][1];
    		
    		for(int j=0; j<=M; j++) { //버거
    			for(int k=0; k<=K; k++) { //감튀
    				dp[i][j][k] = dp[i-1][j][k]; //주문을 선택하지 않은경우
    				
    				//주문을 선택한 경우
    				if(j>=orderBugger && k>=orderFries && dp[i-1][j-orderBugger][k-orderFries]!=-1) {
    					if (dp[i][j][k] == -1) {
                            dp[i][j][k] = dp[i-1][j-orderBugger][k-orderFries] + 1;
                        } else {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-orderBugger][k-orderFries] + 1);
                        }
    				}
    			}
    		}
    	}
    	
    	int max = 0;
		for(int j=1; j<=M; j++) {
			for(int k=1; k<=K; k++) {
				max = Math.max(max,dp[N][j][k]);
			}
		}
    	System.out.println(max);
    }//end main
}