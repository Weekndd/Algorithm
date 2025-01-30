import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = num 
        				+ arr[i-1][j]
        				+ arr[i][j-1]
        				- arr[i-1][j-1];
        	}
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
        	for(int a=0; a<=N-i; a++) {
    			for(int b=0; b<=N-i; b++) {
    				int sum = arr[a+i][b+i]
    						- arr[a][b+i]
    						- arr[a+i][b]
    						+ arr[a][b];
    				max = Math.max(sum,max);
    			}
    		}
        }
        System.out.println(max);
    }//end main
}