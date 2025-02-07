import java.util.*;
import java.io.*;

class Main {
	static class Space implements Comparable<Space>{
		int r, c, cost;
		Space(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		public int compareTo(Space o1) {
			return this.cost - o1.cost;
		}
	}
	static int[] dirR = new int[] {0,0,-1,1};
	static int[] dirC = new int[] {-1,1,0,0};
	static int[][] costs;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i=0; i<N; i++) {
        	map[i] = br.readLine().toCharArray();
        }
        costs = new int[N][N];
        for(int i=0; i<N; i++) {
        	Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = 0;
        PriorityQueue<Space> pq = new PriorityQueue<>();
        pq.offer(new Space(0,0,0));
        
        int ans = 0;
        while(!pq.isEmpty()) {
        	Space now = pq.poll();
        	int r = now.r;
        	int c = now.c;
        	if(r==N-1 && c==N-1) {
        		ans = now.cost;
        		break;
        	}
        	
        	for(int d=0; d<4; d++) {
        		int nr = r + dirR[d];
        		int nc = c + dirC[d];
        		if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
        		if(map[nr][nc]=='0' && costs[nr][nc] > costs[r][c]+1) {
        			costs[nr][nc] = costs[r][c] + 1;
        			pq.offer(new Space(nr,nc,costs[r][c] + 1));
        		}
        		else if(map[nr][nc]=='1' && costs[nr][nc] > costs[r][c]) {
        			costs[nr][nc] = costs[r][c];
        			pq.offer(new Space(nr,nc,costs[r][c]));
        		}
        	}
        }
        System.out.println(ans);
    }//end main
}