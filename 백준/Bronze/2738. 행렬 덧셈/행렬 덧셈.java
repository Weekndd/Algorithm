import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//end input
		
		int[][] res = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				res[i][j] = A[i][j] + B[i][j];
			}
		}
		for(int i[] : res) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println("");
		}
		
	}//end main
}