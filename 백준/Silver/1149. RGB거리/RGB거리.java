import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input
		
		for(int i=1; i<N; i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]); 
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]); 
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]); 
		}
		System.out.println(Math.min(arr[N-1][0], Math.min(arr[N-1][1], arr[N-1][2])));
	}//end main
	

}