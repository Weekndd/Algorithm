
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		
		Queue<int[]> water = new ArrayDeque<>();
		Queue<int[]> mouse = new ArrayDeque<>();
		int er=0,ec=0;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c=='S') mouse.add(new int[] {i,j,0});
				else if(c=='D') { er = i; ec = j; }
				else if(c=='*') { water.add(new int[] {i,j}); }
			}
		}
		//end input
		int[][] visited = new int[R][C];
		int[] dirR = new int[] {0,0,-1,1};
		int[] dirC = new int[] {-1,1,0,0};
		
		visited[mouse.peek()[0]][mouse.peek()[1]] = 2;
		for(int[] i : water) visited[i[0]][i[1]] = 1;
		
		int ans = 0;
		loop:
		while(true) {
			if(mouse.isEmpty()) break;
			
			//물 이동
			int size = water.size();
			for(int i=0; i<size; i++) {
				int[] now = water.poll();
				
				for(int d=0; d<4; d++) {
					int nr = now[0]+dirR[d];
					int nc = now[1]+dirC[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(visited[nr][nc]==1 || arr[nr][nc]=='D'|| arr[nr][nc]=='X') continue;
					visited[nr][nc] = 1;
					water.add(new int[] {nr,nc});
				}
			}
			
			//고슴도치 이동
			size = mouse.size();
			for(int i=0; i<size; i++) {
				int[] now = mouse.poll();
				if(now[0]==er && now[1]==ec) {
					ans = now[2];
					break loop;
				}
				
				for(int d=0; d<4; d++) {
					int nr = now[0]+dirR[d];
					int nc = now[1]+dirC[d];
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(visited[nr][nc]==1 || visited[nr][nc]==2 || arr[nr][nc]=='X') continue;
					mouse.add(new int[] {nr, nc, now[2]+1});
					visited[nr][nc] = 2;
				}
			}
		}
		System.out.println(ans==0 ? "KAKTUS" : ans);
	}//end main
}
