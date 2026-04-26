import java.io.*;
import java.util.*;
public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int row;
	private static int col;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int[] dirX = new int[] {-1,1,0,0};
	private static int[] dirY = new int[] {0,0,-1,1};
	private static int attack = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
		visited = new boolean[row][col];
		
		arr = new char[row][col];
		for(int i=0; i<row; i++) {
			String line = br.readLine();
			arr[i] = line.toCharArray();
		}//end input
		
		bfs('W');
		bfs('B');
		System.out.println(sb);
	}//end main
	
	public static void bfs(char color) {
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				boolean flag = false;
				int count = 0;
				
				if(arr[i][j]== color && !visited[i][j]) {
					que.offer(new int[] {i,j});
					
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
							if(arr[nextX][nextY] == color && !visited[nextX][nextY]) {
								que.offer(new int[] {nextX,nextY});
								visited[nextX][nextY] = true;
								flag = true;
								count++;
							}
						}//end k for
						if(!flag) count++;
					}//end while
					attack += (long)Math.pow(count, 2);
				}//end if
			}
		}//end outer for
		sb.append(attack+" ");
		attack = 0;
		visited = new boolean[row][col];
	}//end bfs
}