import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=M; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + num; 
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
        	st = new StringTokenizer(br.readLine());
        	int sr = Integer.parseInt(st.nextToken());
        	int sc = Integer.parseInt(st.nextToken());
        	int er = Integer.parseInt(st.nextToken());
        	int ec = Integer.parseInt(st.nextToken());
        	int size = (er-sr + 1) * (ec-sc + 1);
        	sb.append((arr[er][ec] - arr[er][sc-1] - arr[sr-1][ec] + arr[sr-1][sc-1])/size+"\n");
        }
        System.out.println(sb);
    }//end main
}