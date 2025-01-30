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
        	for(int j=1; j<=N; j++) {
        		for(int a=0; a<i; a++) {
        			for(int b=0; b<j; b++) {
        				if(i-a != j-b) continue;
        				int sum = arr[i][j]
        						- arr[a][j]
        						- arr[i][b]
        						+ arr[a][b];
        				max = Math.max(sum,max);
        			}
        		}
        	}
        }
        System.out.println(max);
    }//end main
}