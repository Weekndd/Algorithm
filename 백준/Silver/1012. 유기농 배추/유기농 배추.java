import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=0; test<T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int cabbage= Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[row][col]; //문제에서 주어진 최대값
			boolean[][] visited = new boolean[row][col];
			
			for(int i=0; i<cabbage; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			int count =0;
			for(int i=0; i<row; i++) {
				
				for(int j=0; j<col; j++) {
					if(arr[i][j]==1 && visited[i][j]!=true) {
						bfs(i,j,visited, row, col, arr);
						count++;
					}
				}//end for j
			}//end for i
			System.out.println(count);
			
		}//end for Test
		
	}//end main
	
	private static void bfs(int startX, int startY, boolean[][] visited, int row, int col, int[][] arr) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {startX,startY});
		visited[startX][startY] = true;
		
		//배추의 상하좌우에 인전한 배추가 있는지 확인하기 위한 설정 좌표
		int[] nearX = {0,0,-1,1};
		int[] nearY = {1,-1,0,0};
		
		while(!que.isEmpty()) {
			int[] location = que.poll();
			
			for(int i=0; i<4; i++) {
				int x = location[0]+nearX[i];
				int y = location[1]+nearY[i];
				
				if(x<0 || y<0 || x>=row || y>=col) {
					continue;
				}
				if(arr[x][y] == 1 && visited[x][y]!=true) {
					que.offer(new int[] {x,y});
					visited[x][y] = true;
				}
			}
			
		}
		
		
	}//end BFS
	
	
}