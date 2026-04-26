import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];
		DP[0] = 0;
		DP[1] = 1;
		
		for(int i=2; i<=N; i++) {
				DP[i] = DP[i-1];
			for(int j=1; j*j<=i; j++) {
				DP[i] = Math.min(DP[i], DP[i-j*j]);
			}
			DP[i]++;
		}
		System.out.println(DP[N]);
	}//end main
}