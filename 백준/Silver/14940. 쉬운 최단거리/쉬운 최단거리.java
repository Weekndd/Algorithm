import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int[] start = null;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) {
					start = new int[] {i,j};
				}
				map[i][j] = num;
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(start);
		map[start[0]][start[1]] = 0;
		visited[start[0]][start[1]] = true; 
		int[] nearRow = new int[] {-1,1,0,0};
		int[] nearCol = new int[] {0,0,-1,1};
		while(!que.isEmpty()) {
			int[] location = que.poll();
			int nowRow = location[0];
			int nowCol = location[1];
			
			for(int i=0; i<4; i++) {
				int nextRow = nowRow + nearRow[i];
				int nextCol = nowCol + nearCol[i];
				if(nextRow<0 || nextRow>=N || nextCol<0 || nextCol>=M) {
					continue;
				}
				if(map[nextRow][nextCol]==1 && visited[nextRow][nextCol] == false) {
					que.offer(new int[] {nextRow, nextCol});
					visited[nextRow][nextCol] = true;
					map[nextRow][nextCol] = map[nowRow][nowCol] + 1; 
				}
			}
			
		}// end BFS
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					map[i][j] = -1;
				}
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	
	}//end main
}