import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(arr[i][j]==0) continue;
        		int[] temp = bfs(i,j);
        		if(cnt==temp[0]) {
    				ans = Math.max(ans, temp[1]);
    			}
    			else if(cnt<temp[0]){
    				cnt = temp[0];
    				ans = temp[1];
    			}
        	}
        }
        System.out.println(ans);
    }//end main
    
    static public int[] bfs(int r, int c) {
    	int cnt = 0;
    	int start = arr[r][c];
    	int last = 0;
    	int[] dirR = new int[] {-1,1,0,0};
    	int[] dirC = new int[] {0,0,-1,1};
    	
    	boolean[][] check = new boolean[N][M];
    	check[r][c] = true;
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {r,c,0});
    	
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		if(cnt<now[2]) {
    			cnt = now[2];
    			last = arr[now[0]][now[1]];
    		}
    		for(int d=0; d<4; d++) {
        		int nr = now[0] + dirR[d];
        		int nc = now[1] + dirC[d];
        		if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
        		if(arr[nr][nc]==0 || check[nr][nc]) continue;
        		check[nr][nc] = true;
        		que.offer(new int[] {nr,nc,now[2]+1});
        	}
    	}
    	return new int[] {cnt, start+last};
    }
}