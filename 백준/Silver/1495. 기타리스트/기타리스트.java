import java.io.*;
import java.util.*;

public class Main {  //기타리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][M+1];
        for(int i=0; i<=N; i++) {
        	Arrays.fill(dp[i],-1);
        }
        dp[0][S] = 1;
        
        for(int i=1; i<=N; i++) {
        	int vol = arr[i];
        	for(int j=0; j<=M; j++) {
        		if(dp[i-1][j]==1) {
        			if(j+vol<=M) dp[i][j+vol] = 1;
        			if(j-vol>=0) dp[i][j-vol] = 1;
        		}
        	}
        }
        
        int ans = -1;
        for(int i=0; i<=M; i++) {
        	if(dp[N][i]==1) {
        		ans = Math.max(ans,i);
        	}
        }
        System.out.println(ans==-1?-1:ans);
    }//end main
}