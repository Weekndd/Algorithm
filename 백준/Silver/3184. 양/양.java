import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for(int i=0; i<R; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        int[] dirR = new int[] {0,0,-1,1};
        int[] dirC = new int[] {-1,1,0,0};
        
        boolean[][] visited = new boolean[R][C];
        
        int totalSheep = 0;
        int totalWolf = 0;
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(visited[i][j] || map[i][j]=='#') continue;
        		Queue<int[]> que = new LinkedList<>();
        		visited[i][j] = true;
        		que.offer(new int[] {i,j});
        		int sheep = 0;
        		int wolf = 0;
        		if(map[i][j]=='o') sheep++;
        		else if(map[i][j]=='v') wolf++;
        		
        		while(!que.isEmpty()) {
        			int[] now = que.poll();
        			for(int d=0; d<4; d++) {
        				int nr = dirR[d] + now[0];
        				int nc = dirC[d] + now[1];
        				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
        				if(map[nr][nc]=='#' || visited[nr][nc]) continue;
        				if(map[nr][nc]=='v') wolf++;
        				else if(map[nr][nc]=='o') sheep++;
        				visited[nr][nc] = true;
        				que.offer(new int[] {nr,nc});
        			}
        		}
        		if(sheep>wolf) totalSheep += sheep;
        		else totalWolf += wolf;
        	}
        }
        System.out.println(totalSheep+" "+totalWolf);
    }//end main
}