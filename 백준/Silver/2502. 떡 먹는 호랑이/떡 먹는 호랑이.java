import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int day = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int[] dp = new int[day+1];
        for(int i=1; i<=cnt; i++) {
        	dp[1] = i;
        	for(int j=i+1; j<=cnt; j++) {
        		dp[2] = j;
        		for(int k=3; k<=day; k++) {
            		dp[k] = dp[k-1]+dp[k-2];
            		if(k==day && dp[k]==cnt) {
            			System.out.println(i+"\n"+j);
            			return;
            		}
            	}
        	}
        }
    }//end main

}