import java.io.*;
import java.util.*;

public class Main {
	static int depth, N;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        
        arr = new int[depth];
        visited = new boolean[N];
        recur(0,0);
        System.out.println(sb);
	}
    
    public static void recur(int cnt, int start) {
    	if(cnt==depth) {
    		for(int i=0; i<depth; i++) {
    			sb.append(arr[i]+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i=start; i<N; i++) {
    		if(visited[i]) continue;
    		arr[cnt] = i+1;
    		visited[i] = true;
    		recur(cnt+1,i+1);
    		visited[i] = false;
    	}
    }//end recur
}
