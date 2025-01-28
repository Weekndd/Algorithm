import java.util.*;
import java.io.*;

class Main {
	static int[] dirR = new int[] {0,0,-1,1};
	static int[] dirC = new int[] {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int SR = Integer.parseInt(st.nextToken());
        int SC = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ER = Integer.parseInt(st.nextToken());
        int EC = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        boolean[][][] visited = new boolean[N+1][M+1][2];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {SR,SC,0,0});
        visited[SR][SC][0] = true;
        int ans = 0;
        while(!que.isEmpty()) {
        	int[] now = que.poll();
        	int isBroke = now[2];
        	int dis = now[3];
        	if(now[0]==ER && now[1]==EC) {
        		ans = dis;
        		break;
        	}
        	for(int i=0; i<4; i++) {
        		int nr = now[0]+dirR[i];
        		int nc = now[1]+dirC[i];
        		if(nr<=0 || nr>N || nc<=0 || nc>M) continue;
        		if(visited[nr][nc][isBroke]) continue;
        		if(map[nr][nc] == 1 && isBroke==1) continue; //벽인데, 이미 부셨으면 건너뛰기
        		
        		//만약 벽이면
        		if(map[nr][nc] == 1) {
        			visited[nr][nc][isBroke+1] = true;
        			que.offer(new int[] {nr,nc,isBroke+1,dis+1});
        		}
        		else {
        			visited[nr][nc][isBroke] = true;
        			que.offer(new int[] {nr,nc,isBroke,dis+1});
        		}
        	}
        }//end while
        System.out.println(ans==0 ? -1 : ans);
    }//end main
}