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
		
		while(!(W==0 && H==0)) {
			int[][] map = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}//end j for 
			}//end i for 
			//end input 
			
			
			boolean[][] visited = new boolean[H][W]; 
			int[] optionX = {-1,1,0,0, -1,-1,1,1};
			int[] optionY = {0,0,-1,1, 1,-1,1,-1};
			
			Queue<int[]> que = new LinkedList<>();
			int count = 0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]==1 &&visited[i][j]!=true) {
						
						
						//bfs
						que.offer(new int[] {i,j});
						
						while(!que.isEmpty()) {
							int[] start = que.poll();
							int nowX = start[0];
							int nowY = start[1];
									
							for(int k=0; k<8; k++) {
								int nextX= nowX+optionX[k];
								int nextY= nowY+optionY[k];
								
								if(nextX<0 || nextY<0 || nextX>=H || nextY>=W) {
									continue;
								}
								if(map[nextX][nextY]==1 && visited[nextX][nextY]!=true) {
									que.offer(new int[] {nextX,nextY});
									visited[nextX][nextY] = true;
									
								}
								
							}//end k for
							
						}//end bfs() while
						count++;
					}//end if
					
				}//end for j
			}//end i for
			System.out.println(count);
			st = new StringTokenizer(br.readLine()," ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
		}//end while
		
		
		
		
	}//end Main	
}