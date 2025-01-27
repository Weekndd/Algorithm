import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=M; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = num + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];        	}
        }
        long max = Integer.MIN_VALUE;
        for(int i=N; i>=1; i--) {
        	for(int j=M; j>=1; j--) {
        		for(int a=i; a>=1; a--) {
        			for(int b=j; b>=1; b--) {
        				int temp = arr[i][j] 
        						-arr[a-1][j] 
        						-arr[i][b-1] 
        						+arr[a-1][b-1];
        				max = Math.max(temp,max);
        			}
        		}
        	}
        }
        System.out.println(max);
    }//end main
}