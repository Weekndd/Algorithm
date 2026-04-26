import java.util.*;
import java.io.*;

public class Main {
	static int[] dirR = new int[] {0,0,-1,1}; 
	static int[] dirC = new int[] {-1,1,0,0}; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		char[][] map= new char[R][C];
		for(int i=0; i<R; i++) {
			String str= br.readLine();
			map[i] = str.toCharArray();
		}
		//end input
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		boolean[][] visited = new boolean[R][C];
		int[][] dist = new int[R][C];
		for(int i=0; i<R; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		pq.offer(new int[] {0,0,0});
		dist[0][0] = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if(now[0]==R-1 && now[1]==C-1) break;
			
			if(visited[now[0]][now[1]]) continue;
			visited[now[0]][now[1]] = true;
			
			for(int i=0; i<4; i++) {
				int nr = now[0]+dirR[i];
				int nc = now[1]+dirC[i];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(dist[nr][nc]<now[2] || visited[nr][nc]) continue;
				if(map[nr][nc]=='1') {
					pq.offer(new int[] {nr,nc,now[2]+1});
					dist[nr][nc] = now[2]+1;
				}
				else {
					pq.offer(new int[] {nr,nc,now[2]});
					dist[nr][nc] = now[2];
				}
			}
		}//end while
		System.out.println(dist[R-1][C-1]);
	}//end main
}
