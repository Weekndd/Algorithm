import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean visited[][];
	static List<int[]> cloudList = new ArrayList<>();
	static List<int[]> preCloudList;
	static int[] dirR = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dirC = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		//end input
		
		cloudList.add(new int[] {N,1});
		cloudList.add(new int[] {N,2});
		cloudList.add(new int[] {N-1,1});
		cloudList.add(new int[] {N-1,2});
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			moveCloud(dir-1, count);		
			rain();
			increaseWater();
			makeNewCloud();	
		}
		int ans = 0;
		for(int[] i : arr) {
			for(int j : i) ans+=j;
		}
		System.out.println(ans);
	}//end main
	
	
	public static void moveCloud(int dir, int count) {
		preCloudList = new ArrayList<>();
		visited = new boolean[N+1][N+1];
		for(int i=0; i<cloudList.size(); i++) {
			int[] cloud = cloudList.get(i);
			int nr = cloud[0]+dirR[dir]*count%N;
			int nc = cloud[1]+dirC[dir]*count%N;
			
			if(nr<=0) nr = N+nr;
			else if(nr>N) nr = nr-N;
			if(nc<=0) nc = N+nc;
			else if(nc>N) nc = nc-N ;
			
			visited[nr][nc] = true;
			preCloudList.add(new int[] {nr,nc});
		}
	}//end moveCloud
	
	public static void rain() {
		for(int[] cloud : preCloudList) {
			arr[cloud[0]][cloud[1]]++;
		}
	}//end rain
	
	public static void increaseWater() {
		List<Integer> increaseList = new ArrayList<>();
		for(int[] cloud : preCloudList) {
			int count = 0;
			for(int d=1; d<8; d+=2) {
				int nr = cloud[0]+dirR[d];
				int nc = cloud[1]+dirC[d];
				if(nr<=0 || nr>N || nc<=0 || nc>N) continue;
				if(arr[nr][nc]==0)continue;
				count++;
			}
			increaseList.add(count);
		}
		for(int i=0; i<preCloudList.size(); i++) {
			int[] cloud = preCloudList.get(i);
			int water = increaseList.get(i);
			arr[cloud[0]][cloud[1]] += water;
		}
	}//end increaseWater
    
	//새로운 구름으로 초기화
	static public void makeNewCloud() {
		cloudList = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//
				if(!visited[i][j] && arr[i][j]>=2) {
					arr[i][j]-=2;
					cloudList.add(new int[] {i,j});
				}
			}
		}	
	}//end makeNewCloud
}
