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
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] egg = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				egg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//end input
		
		boolean[][] visited = new boolean[H][W];
		int[] dirX = new int[] {-1,1,0,0};
		int[] dirY = new int[] {0,0,-1,1};
		int count = 0;
		
		boolean flag = false;
		int temp = 0;
		Queue<int[]> que = new LinkedList<>();	
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					////
					if(egg[i][j]>0) {
						que.offer(new int[] {i,j});
						visited[i][j] = true;
					}
				}//end j for 
			}//end i for
					
					while(!que.isEmpty()) {
						int[] location = que.poll();
						int nowX = location[0];
						int nowY = location[1];
						
						for(int k=0; k<4; k++) {
							int nextX = nowX+dirX[k];
							int nextY = nowY+dirY[k];
							
							if(nextX<0 || nextY<0 || nextX>=H || nextY>=W) {
								continue;
							}
							
							if(egg[nextX][nextY]>=0 && visited[nextX][nextY]!=true) {
								que.offer(new int[] {nextX,nextY});
								visited[nextX][nextY] = true;
								egg[nextX][nextY] = egg[nowX][nowY]+1;
								
							}
							
						}//end k for
					}//end while

		
		boolean check = false;
		int max = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(egg[i][j]==0) {
					check = true;
				}
				if(egg[i][j] > max) max = egg[i][j];
			}
			
		}
		if(check==true) {
			System.out.println(-1);
		}
		else {
			System.out.println(max-1);
		}
		
	}//end Main	
}