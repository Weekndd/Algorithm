import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] dis = new int[V+1][V+1];
		int inf = 1000000000;
		for(int[] i : dis) Arrays.fill(i, inf);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			dis[A][B] = C;
		}
		for(int k=1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(i==j) continue;
					if(dis[i][j]>dis[i][k]+dis[k][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
		}
		int min = inf;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(dis[i][j]==inf || dis[j][i]==inf) continue;
				min = Math.min(min, dis[i][j]+dis[j][i]);
			}
		}
		System.out.println(min==inf?-1:min);
	}//end main
}
