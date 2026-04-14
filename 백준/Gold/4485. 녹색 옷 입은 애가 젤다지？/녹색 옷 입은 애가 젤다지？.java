import java.io.*;
import java.util.*;

public class Main {
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	public static class Node implements Comparable<Node>{
		int r,c,w;
		Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++ ) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int[][] cost  = new int[N][N];
			for(int i=0; i<N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
			cost[0][0] = map[0][0];
			pq.offer(new Node(0,0,map[0][0]));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				if(now.r == N-1 && now.c == N-1) break;
				for(int d=0; d<4; d++) {
					int nr = now.r + dirR[d];
					int nc = now.c + dirC[d];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					if(cost[nr][nc] <= now.w + map[nr][nc]) continue;
					pq.offer(new Node(nr, nc, now.w + map[nr][nc]));
					cost[nr][nc] = now.w + map[nr][nc];;
				}
			}
			sb.append("Problem " + ++t+": "+cost[N-1][N-1]+"\n");
		}
		System.out.println(sb);
	} //end main
}

