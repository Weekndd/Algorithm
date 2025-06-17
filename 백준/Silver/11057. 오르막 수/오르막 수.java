import java.util.*;
public class Main {
		
	static int N;
	static int[][] dp;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N=Integer.parseInt(sc.next());	//테스트 케이스
		dp= new int[N][10];
		
		for(int i=0;i<10;i++) {
			dp[0][i]=1;
		}
		for(int i = 1; i < N; i++) {	//자리수만큼 반복
			for(int j = 0; j < 10; j++) {	//i자리수의 0~9
				for(int k = j; k < 10; k++) {	
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		System.out.println(Arrays.stream(dp[N-1]).sum()%10007);
	}// main()
}// class Main
