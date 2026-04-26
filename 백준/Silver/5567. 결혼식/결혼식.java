import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a][b] = arr[b][a] = 1;
        }
        //end input
        visited[1] = true;
        dfs(1,0);
        int count = 0;
        for(boolean i : visited) {
        	if(i) count++;
        }
        System.out.println(count-1);
    }//end main
    
    public static void dfs(int start, int depth) {
    	if(depth == 2) {
    		return;
    	}
    	for(int i=1; i<=N; i++) {
    		if(arr[start][i]==1) {
    			visited[i] = true;
    			dfs(i,depth+1);
    		}
    	}
    }
}