import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 
		 int[][] ans = new int[N+1][N+1];
		 int[][] dis = new int[N+1][N+1];
		 for(int i=1; i<=N; i++) {
			 for(int j=1; j<=N; j++) {
				 if(i==j) continue;
				 dis[i][j] = 100000000;
			 }
		 }//dis 초기화
		 
		 for(int i=0; i<M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			 int W = Integer.parseInt(st.nextToken());
			 ans[A][B] = B;
			 ans[B][A] = A;
			 dis[A][B] = W;
			 dis[B][A] = W;
		 }
		 
		 for(int k=1; k<=N; k++) {
			 for(int i=1; i<=N; i++) {
				 if(k==i) continue;
				 for(int j=1; j<=N; j++) {
					 if(i==j || j==k) continue;
					 if(dis[i][j]>dis[i][k]+dis[k][j]) {
						 dis[i][j]=dis[i][k]+dis[k][j];
						 ans[i][j] = ans[i][k];
					 }
				 }
			 }
		 }
		 
		 for(int i=1; i<=N; i++) {
			 for(int j=1; j<=N; j++) {
				 System.out.print(ans[i][j]==0?"- ":ans[i][j]+" ");
			 }
			 System.out.println();
		 }
	}//end main
}
