import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line  = br.readLine();
			char[] lineArr = line.toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(lineArr[j]));
			}
		}
		//end Input
		
		visited[0][0] = true;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		int[] nearX = {1,-1,0,0};
		int[] nearY = {0,0,-1,1};
		
		//bfs
		while(!que.isEmpty()) {
			int[] location = que.poll();
			int nowX = location[0];
			int nowY = location[1];
			
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + nearX[i];
				int nextY = nowY + nearY[i];
				
				if(nextX<0 || nextY<0 || nextX>=N || nextY>=M) {
					continue;
				}
				if(visited[nextX][nextY]!=true && arr[nextX][nextY] == 1) {
					que.offer(new int[] {nextX,nextY});
				arr[nextX][nextY] = arr[nowX][nowY]+1;
				visited[nextX][nextY] = true;
				}
				
				
				
			}//end k for
			
			
			
		}//end while
		
		
		System.out.println(arr[N-1][M-1]);
		
	}//end Main	
}