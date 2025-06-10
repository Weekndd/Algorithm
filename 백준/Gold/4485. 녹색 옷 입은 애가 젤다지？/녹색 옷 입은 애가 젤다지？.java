import java.io.*;
import java.util.*;

public class Main {
	static public class Node implements Comparable<Node>{
		int row, col, wei;
		public Node(int row, int col, int wei) {
			super();
			this.row = row;
			this.col = col;
			this.wei = wei;
		}
		@Override
		public int compareTo(Node o) {
			return this.wei - o.wei;
		}
	}
	static int[] dirR = new int[] {0,0,-1,1};
	static int[] dirC = new int[] {-1,1,0,0};
	
	public static void main(String[] args) throws Exception { //녹색 옷 입은 애가 젤다지?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end input
			
			int[][] minCost = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					minCost[i][j] = Integer.MAX_VALUE;
				}
			}//초기값 세팅
			
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0,0,map[0][0]));
			minCost[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				visited[now.row][now.col]=true;	
				if(now.row==N-1 && now.col==N-1) break;
				
				for(int i=0; i<4; i++) {
					int nr = now.row+dirR[i];
					int nc = now.col+dirC[i];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					if(visited[nr][nc]) continue;
					if(minCost[nr][nc] > now.wei + map[nr][nc]) {
						minCost[nr][nc] = now.wei + map[nr][nc];
						pq.offer(new Node(nr,nc,minCost[nr][nc]));
					}
				}
			}
			sb.append("Problem "+(t++)+": "+minCost[N-1][N-1]+"\n");
		}//end testcase
		System.out.println(sb);
	}//end main
}