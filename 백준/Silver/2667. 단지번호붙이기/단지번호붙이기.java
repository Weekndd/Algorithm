import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			char[] strArr = str.toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(strArr[j]));
			}
		}
		//input end
		
		boolean[][] visited = new boolean[N][N];
		ArrayList<Integer> groupCount = new ArrayList<Integer>();
		
		int group = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && visited[i][j]!=true) {
					
					//bfs
					
					int[] optionX = {1,-1,0,0};
					int[] optionY = {0,0,1,-1};
					
					Queue<int[]> que = new LinkedList<>();
					que.offer(new int[] {i,j});
					visited[i][j] = true; 
					int count = 1;
					
					while(!que.isEmpty()) {
						int[] location = que.poll();
						int nowX = location[0];
						int nowY = location[1];
						for(int k=0; k<4; k++) {
							int nextX = nowX + optionX[k];
							int nextY = nowY + optionY[k];
							if(nextX<0 || nextY<0 || nextX>=N || nextY>=N) {
								continue;
							}
							if(arr[nextX][nextY]==1 && visited[nextX][nextY]!=true) {
								que.offer(new int[] {nextX,nextY});
								visited[nextX][nextY] = true;
								count++;
							}
						}
					}//end while
					groupCount.add(count);
					group++;
					
				}//end if
				
				
			}//end j for 
		}//end i for
		Collections.sort(groupCount);
		
		sb.append(group+"\n");
		for(int i : groupCount) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
		
		
		
	}//end Main	
}