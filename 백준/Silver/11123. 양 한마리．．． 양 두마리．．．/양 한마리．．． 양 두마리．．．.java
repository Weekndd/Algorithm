import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dirR = new int[] {0,0,-1,1};
        int[] dirC = new int[] {-1,1,0,0};
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int R = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	char[][] map = new char[R][C];
        	for(int i=0; i<R; i++) {
        		map[i] = br.readLine().toCharArray();
        	}
        	boolean[][] visited = new boolean[R][C];
        	int cnt = 0;
        	
        	for(int i=0; i<R; i++) {
        		for(int j=0; j<C; j++) {
        			if(map[i][j]=='#' && !visited[i][j]) {
        				visited[i][j] = true;
        				cnt++;
        				Queue<int[]> que = new LinkedList<>();
        				que.offer(new int[] {i,j});
        				while(!que.isEmpty()) {
        					int[] now = que.poll();
        					for(int d=0; d<4; d++) {
        						int nr = dirR[d] + now[0];
        						int nc = dirC[d] + now[1];
        						if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
        						if(map[nr][nc]!='#' || visited[nr][nc]) continue;
        						visited[nr][nc] = true;
        						que.offer(new int[] {nr,nc});
        					}
        				}
        			}
        		}
        	}
        	sb.append(cnt+"\n");
        }//end testcase
        System.out.println(sb);
    }//end main
}