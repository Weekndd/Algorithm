
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); //편의점 수
			
			StringTokenizer st = new StringTokenizer(br.readLine()); // 상근이네 집
			int hr = Integer.parseInt(st.nextToken());
			int hc = Integer.parseInt(st.nextToken());

			int[][] marts = new int[N][2]; //편의점
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				marts[i][0] = Integer.parseInt(st.nextToken());
				marts[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()); //펜타포트
			int pr = Integer.parseInt(st.nextToken());
			int pc = Integer.parseInt(st.nextToken());
			
			Queue<int[]> que = new LinkedList<>();
			boolean[] visited = new boolean[N];
			que.offer(new int[] {hr,hc});
			
			boolean isPantaport = false;
			
			while(!que.isEmpty()) {
				int[] now = que.poll();
				if((Math.abs(now[0]-pr)+Math.abs(now[1]-pc)) <= 1000) {
					isPantaport = true;
					break;
				}
				for(int i=0; i<N; i++) {
					int[] mart = marts[i];
					if(visited[i]) continue;
					
					if((Math.abs(now[0]-mart[0])+Math.abs(now[1]-mart[1])) > 1000) continue;
					que.offer(mart);
					visited[i] = true;
				}
			}
			sb.append(isPantaport?"happy\n":"sad\n");
		}//end testCase
		System.out.println(sb);
	}//end main
}
