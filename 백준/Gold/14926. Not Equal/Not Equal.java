import java.io.*;
import java.util.*;

public class Main {
	static int N, arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) arr[i][j] = 0;
				else arr[i][j] = 1;
			}
		}//초기화
		sb.append("a1 ");
		dfs(0);
		System.out.println(sb);
	}//end main
	static public void dfs(int start) {
		boolean isLast = false;
		if(start==N-1) {
			for(int i=1; i<N; i++) {
				if(arr[start][i]==1) {
					arr[start][i] = 0;
					arr[i][start] = 0;
					sb.append("a"+(i+1)+" ");
					dfs(i);
					isLast = true;
					break;
				}
			}
			if(!isLast) sb.append("a1 ");
		}
		else {
			for(int i=0; i<N; i++) {
				if(arr[start][i]==1) {
					arr[start][i] = 0;
					arr[i][start] = 0;
					sb.append("a"+(i+1)+" ");
					dfs(i);
					break;
				}
			}//end for
		}//end else 
	}
}
