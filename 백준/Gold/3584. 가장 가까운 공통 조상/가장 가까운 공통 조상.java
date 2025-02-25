import java.util.*;
import java.io.*;

public class Main {
	static int nodeA, nodeB, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] parents = new int[N+1];
			for(int i=1; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				parents[B] = A;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			nodeA = Integer.parseInt(st.nextToken());			
			nodeB = Integer.parseInt(st.nextToken());			
			
			int next = nodeA;
			boolean[] visited = new boolean[N+1];
			while(true) {
				if(nodeA==0) break;
				visited[nodeA] = true;
				nodeA = parents[nodeA];
			}
			while(true) {
				if(nodeB==0) break;
				if(visited[nodeB]) {
					ans = nodeB;
					sb.append(ans+"\n");
					break;
				}
					nodeB = parents[nodeB];
			}
		}//endTest
		System.out.println(sb);
	}//end main
}
