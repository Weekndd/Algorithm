import java.util.*;
import java.io.*;

public class Main { //얼어붙은 여행지

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			for(int r=Math.abs(ec-N); r<Math.abs(N-sr); r++) {
				for(int c=sc; c<er; c++ ) {
					map[r][c] = 1;
				}
			}
		}
		List<Integer> cntList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean[][] visited = new boolean[N][M];
		int[] dirR = new int[] {0,0,-1,1};
		int[] dirC = new int[] {-1,1,0,0};
		
		int land = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) continue;
				if(visited[i][j]) continue;
				
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i,j});
				visited[i][j] = true;
				int cnt = 1;
				
				while(!que.isEmpty()) {
					int[] location = que.poll();
					
					for(int k=0; k<4; k++) {
						int nextR = location[0]+dirR[k];
						int nextC = location[1]+dirC[k];
						if(nextR<0 || nextR>=N || nextC<0 || nextC>=M) continue;
						if(visited[nextR][nextC] || map[nextR][nextC]==1) continue;
						que.offer(new int[] {nextR,nextC});
						visited[nextR][nextC] = true;
						cnt++;
					}
				}
				land++;
				cntList.add(cnt);
			}
		}
		sb.append(land+"\n");
		Collections.sort(cntList);
		for(int i : cntList) sb.append(i+" ");
		System.out.println(sb);
	}//end main
}
