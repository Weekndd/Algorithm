import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][];
		
		for(int i=0; i<N; i++) {
			int[] vertex = new int[i+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<vertex.length; j++) {
				vertex[j] = Integer.parseInt(st.nextToken());
			}
			arr[i] = vertex;
		}
		//end input
		int max = arr[0][0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<arr[i].length; j++) {
				//첫번째 값일 때
				if(j==0) { 
					arr[i][j] += arr[i-1][0];
				}
				//마지막 값일 때
				else if(j==arr[i].length-1) { 
					arr[i][j] += arr[i-1][j-1];
				}
				else {
					arr[i][j] = Math.max((arr[i][j] + arr[i-1][j-1]), (arr[i][j] + arr[i-1][j]));
				}
				
				if(arr[i][j]>max) {
					max = arr[i][j];
				}
			}
		}
		if(N==2) {
			max = Math.max(arr[1][0], arr[1][1]);
		}
		System.out.println(max);
	
	}//end main
}