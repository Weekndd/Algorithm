import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] B = new int[N+1];
		boolean[] visitedB = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			B[i] = Integer.parseInt(st.nextToken()); 
		}
		//end input
		Arrays.sort(A);
		int sum = 0;
		for(int i=1; i<=N; i++) {
			int maxIndex = 0;
			
			for(int j=1; j<=N; j++) {
				if(B[j]>=B[maxIndex] && visitedB[j]==false) {
					maxIndex = j;
				}
			}//end j
			visitedB[maxIndex] = true;
			sum += A[i]*B[maxIndex];
		}//end i
		System.out.println(sum);
		
	}//end main
}