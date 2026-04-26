import java.io.*;
import java.util.*;

public class Main {
	static Integer[] DP;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int [N+1];
		DP = new Integer[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//디폴트값 초기화
		DP[0] = arr[0];
		DP[1] = arr[1];
		//end input
		
		//N이 1일때 예외처리
		if(N>=2) {
			DP[2] = arr[1] + arr[2];
		}
		System.out.println(find(N));
		
		
	}
	
	private static int find(int a) {
		//아직 탐색하지 않은 N번째 계단인 경우
		if(DP[a]==null) {
			DP[a] = Math.max(find(a-2), find(a-3)+arr[a-1])+arr[a];
		}
		return DP[a]; 
	}
}