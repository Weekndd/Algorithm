import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] arr = new int[row][col];
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input;
		
		boolean[][] visited = new boolean[row][col];
		int[] dirX = new int[] {-1,1,0,0};
		int[] dirY = new int[] {0,0,-1,1};
		Queue<int[]> que = new LinkedList<>();
		int size = 0;
		int count = 0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				int tempSize = 0;
				boolean flag = false;
				if(arr[i][j] == 1 && !visited[i][j]) {
					count++;
					que.offer(new int[]{i,j});
					while(!que.isEmpty()) {
						
						int[] location = que.poll();
						int nowX = location[0];
						int nowY = location[1];
						
						for(int k=0; k<4; k++) {
							int nextX = nowX + dirX[k];
							int nextY = nowY + dirY[k];
							if(nextX<0 || nextX>=row || nextY<0 || nextY>=col) {
								continue;
							}
							if(!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
								que.offer(new int[] {nextX,nextY});
								visited[nextX][nextY] = true;
								tempSize++;
								flag = true;
							}
						}
						
					}//end while
					if(!flag) tempSize++;
					if(tempSize>size) size = tempSize;
				}//end if
				
			}//end inner for
			
		}
		
		System.out.println(count+"\n"+size);
		
		
	}//end main
}