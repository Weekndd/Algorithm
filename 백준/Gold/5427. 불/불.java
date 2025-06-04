import java.util.*;
import java.io.*;

public class Main {
	static int[] dirR = new int[] {-1,1,0,0};
	static int[] dirC = new int[] {0,0,-1,1};
	static int r, c;
	static Queue<int[]> fireQ;
	static Queue<int[]> personQ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			char[][] map = new char[r][c];
			int[] start = new int[2];
			personQ = new LinkedList<>();
			fireQ = new LinkedList<>();
			for(int i=0; i<r; i++) {
				String str = br.readLine();
				for(int j=0; j<c; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='@') start = new int[] {i,j,0};
					else if(map[i][j]=='*') fireQ.offer(new int[] {i,j});
				}
			}//end input
			
			//시뮬레이션 시작
			boolean[][] check = new boolean[r+1][c+1];
			personQ.offer(start);
			check[start[0]][start[1]] = true;
			boolean flag = false;
			
			loop:
			while(!personQ.isEmpty()) {
				
				//불 번짐
				int fireSize = fireQ.size();
				for(int i=0; i<fireSize; i++) {
					int[] fire = fireQ.poll();
					for(int d=0; d<4; d++) {
						int fr = fire[0] + dirR[d];
						int fc = fire[1] + dirC[d];
						if(fr>=r || fr<0 || fc>=c || fc<0) continue;
						if(map[fr][fc]=='#' || map[fr][fc]=='*') continue;
						map[fr][fc] = '*';
						fireQ.offer(new int[] {fr,fc});
					}
				}

				//상근이 움직임
				int personSize = personQ.size();
				for(int i=0; i<personSize; i++) {
					int[] now = personQ.poll();
					for(int d=0; d<4; d++) {
						int nr = now[0]+dirR[d];
						int nc = now[1]+dirC[d];
						//기저조건
						if(nr>=r || nr<0 || nc>=c || nc<0) {
							flag = true;
							sb.append(now[2]+1+"\n");
							break loop;
						}
						if(check[nr][nc]) continue;
						if(map[nr][nc]=='.') {
							personQ.offer(new int[] {nr, nc, now[2]+1});
							check[nr][nc] = true;
						}
					}
				}
			}//end while
			if(!flag) sb.append("IMPOSSIBLE\n");
		}//end testcase
		System.out.println(sb);
	}//end main
}
