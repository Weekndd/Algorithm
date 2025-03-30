import java.io.*;
import java.util.*;

public class Main {
	private static boolean[][] visited;
	private static Queue<int[]> que = new LinkedList<>();
	private static char[][] map;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}//end input
		
		/*일반 버전*/
		visited = new boolean[N][N];
		int count = bfs();
		sb.append(count+" ");
		
		/*적녹색약 버전*/
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		count = bfs();
		sb.append(count);
		System.out.println(sb);
	}//end main
	
	private static int bfs() {
		int count = 0;
		int[] dirX = new int[] {-1,1,0,0};
		int[] dirY = new int[] {0,0,-1,1};
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) {
					continue; //이미 방문했던 곳이기 때문에 패스
				}
				char color = map[i][j];
				que.offer(new int[] {i,j});
				while(!que.isEmpty()) {
					int[] location = que.poll();
					int nowX = location[0];
					int nowY = location[1];
					for(int k=0; k<4; k++) {
						int nextX = nowX + dirX[k];
						int nextY = nowY + dirY[k];
						if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
							continue;
						}
						if(map[nextX][nextY] == color && visited[nextX][nextY] == false) {
							visited[nextX][nextY] = true;
							que.offer(new int[] {nextX,nextY});
						}
						
					}
				}//end while
				count++;
			}
		}
		return count;
	}//end bfs
	
}