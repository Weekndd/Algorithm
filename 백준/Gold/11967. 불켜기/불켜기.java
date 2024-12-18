import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	static boolean[][] check;
	static boolean[][] light;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<List<int[]>>[][] way = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				way[i][j] = new ArrayList();
				way[i][j].add(new ArrayList<int[]>());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			way[startR][startC].get(0).add(new int[] {endR,endC});
		}
		check = new boolean[N+1][N+1];
		light = new boolean[N+1][N+1];
		Queue<int[]> que = new LinkedList<int[]>(); 
		que.offer(new int[] {1,1});
		check[1][1] = true;
		light[1][1] = true;
		
		int turnLight = 1;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			
			connect(r, c, que);
			for(int i=0; i<way[r][c].get(0).size(); i++) {
				int nr = way[r][c].get(0).get(i)[0];
				int nc = way[r][c].get(0).get(i)[1];
				if(check[nr][nc]) continue;
				if(!light[nr][nc]) turnLight++;
				light[nr][nc] = true;
				if(Math.abs(r-nr)+Math.abs(c-nc) > 1 && !isConnected(nr, nc)) continue;
				check[nr][nc] = true;
				que.offer(new int[] {nr, nc});
			}
		}//end while
		System.out.println(turnLight);
	}//end main
	
	public static boolean isConnected(int r, int c) {
		boolean res = false;
		for(int d=0; d<4; d++) {
			int dr = r + dirR[d];
			int dc = c + dirC[d];
			if(dr<1 || dr>N || dc<1 || dc>N) continue;
			if(check[dr][dc]) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public static void connect(int r, int c, Queue<int[]> que) {
		for(int d=0; d<4; d++) {
			int dr = r + dirR[d];
			int dc = c + dirC[d];
			if(dr<=0 || dr>N || dc<=0 || dc>N) continue;
			if(!check[dr][dc] && light[dr][dc]) {
				check[dr][dc] = true;
				que.offer(new int[] {dr, dc});
			}
		}
	}
}
