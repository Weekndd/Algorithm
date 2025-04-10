import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int floor = Integer.parseInt(st.nextToken()); 
		
		int[][][] tomato = new int[floor][row][col];
		
		for(int i=0; i<floor; i++) {
			for(int j=0; j<row; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0; k<col; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					
				}//end k for
			}//end j for
		}//end i for
		
		//end input
		
		Queue<int[]> que = new LinkedList<>();
		boolean[][][] visited = new boolean[floor][row][col];
		
		//처음에 받은 토마토 que에 넣기
		for(int i=0; i<floor; i++) {
			for(int j=0; j<row; j++) {
				for(int k=0; k<col; k++) {
					if(tomato[i][j][k] == 1 ) {
						que.offer(new int[] {i,j,k});
					}
				}
			}
		}
		
		//BFS
		int[] nearX = new int[] {1,-1,0,0,0,0};
		int[] nearY = new int[] {0,0,1,-1,0,0};
		int[] nearZ = new int[] {0,0,0,0,1,-1};
		
		while(!que.isEmpty()) {
			int location[] = que.poll();
			int nowZ = location[0];
			int nowX = location[1];
			int nowY = location[2];
			
			for(int i=0; i<6; i++) {
				int nextX = nearX[i] + nowX;
				int nextY = nearY[i] + nowY;
				int nextZ = nearZ[i] + nowZ;
				if(nextX<0|| nextX>=row || nextY<0 || nextY>=col || nextZ<0 || nextZ>=floor) {
					continue;
				}
				if(tomato[nextZ][nextX][nextY]==0 && visited[nextZ][nextX][nextY] != true) {
					tomato[nextZ][nextX][nextY] = tomato[nowZ][nowX][nowY] + 1;
					que.offer(new int[] {nextZ,nextX,nextY});
					visited[nextZ][nextX][nextY] = true;
				}
			}
			
		}//end while
		
		int max = 0;
		boolean flag = false;
		loop:
		for(int i[][] : tomato) {
			for(int j[] : i) {
				for(int k : j) {
					if(k==0) {
						flag = true;
						break loop;
					}
					if(k>max) max = k;
				}
			}
		}
		
		if(flag) {
			System.out.println(-1);
		}
		else {
			System.out.println(max-1);
		}
		
		
		
	}//end main
}