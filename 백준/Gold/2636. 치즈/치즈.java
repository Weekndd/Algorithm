import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[][];
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	public static void main(String[] args) throws Exception {
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
		int time = 0;
		int pre = 0;
		while(true) {
			List<int[]> meltedCheese = checkMeltedCheese();
			if(meltedCheese.isEmpty()) {
				break;
			}
			pre = meltedCheese.size();
			deleteCheese(meltedCheese);
			time++;
		}
		System.out.println(time+"\n"+pre);
	}//end main
	static List<int[]> checkMeltedCheese() {
		List<int[]> meltedCheese = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0,0});
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int i=0; i<4; i++) {
				int nr = now[0]+dirR[i];
				int nc = now[1]+dirC[i];
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(arr[nr][nc]==1) meltedCheese.add(new int[] {nr,nc});
				else que.offer(new int[] {nr,nc});
			}
		}
		return meltedCheese;
	}
	
	static void deleteCheese(List<int[]> meltedCheese) {
		for(int i=0; i<meltedCheese.size(); i++) {
			int[] cheese = meltedCheese.get(i);
			arr[cheese[0]][cheese[1]] = 0;
		}
	}
}