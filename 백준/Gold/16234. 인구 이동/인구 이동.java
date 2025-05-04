import java.util.*;
import java.io.*;

public class Main {
	static int N, L, R, arr[][];
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//end input
		int ans = 0;
		while(true) {
			int res = findUnion();
			if(res==0) break;
			ans += res;
		}
		System.out.println(ans);
		
	}//end main
	public static int findUnion() {
		boolean[][] check = new boolean[N][N];
		int flag = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j]) continue;
				Queue<int[]> que = new LinkedList<int[]>();
				check[i][j] = true;
				que.offer(new int[] {i,j});
				List<int[]> unionList = new ArrayList<int[]>();
				unionList.add(new int[] {i,j});
				int sum = arr[i][j];
				
				while(!que.isEmpty()) {
					int[] now = que.poll();
					for(int d=0; d<4; d++) {
						int nr = now[0]+dirR[d];
						int nc = now[1]+dirC[d];
						if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
						if(check[nr][nc]) continue;
						if(L<=Math.abs(arr[now[0]][now[1]]-arr[nr][nc]) && Math.abs(arr[now[0]][now[1]]-arr[nr][nc])<=R) { //차이가 L이상 R이하							unionList.add(new int[] {nr,nc});
							check[nr][nc] = true;
							flag = 1;
							que.offer(new int[] {nr,nc});
							sum += arr[nr][nc];
							unionList.add(new int[] {nr,nc});
						}
					}
				}//end while
				for(int k=0; k<unionList.size(); k++) {
					int[] country = unionList.get(k);
					arr[country[0]][country[1]] = sum/unionList.size();
				}
			}//end for j
		}//end for i
		return flag;
	}
}
