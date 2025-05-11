import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
        	}
        }//end input
        StringBuilder sb = new StringBuilder();
        for(int m=0; m<M; m++) {
        	int sum = 0;
        	st = new StringTokenizer(br.readLine());
        	int startR= Integer.parseInt(st.nextToken());
        	int startC= Integer.parseInt(st.nextToken());
        	int endR= Integer.parseInt(st.nextToken());
        	int endC= Integer.parseInt(st.nextToken());
        	for(int i=startR; i<=endR; i++) {
        		sum += arr[i][endC] - arr[i][startC-1];
        	}
        	sb.append(sum+"\n");
    	}
        System.out.println(sb);
	}
}
