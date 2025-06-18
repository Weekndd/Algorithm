import java.util.*;
import java.io.*;

public class Main {
	static int N,M,cnt = 0;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[10];
		if(M!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				check[Integer.parseInt(st.nextToken())]++;
			}
		}
		recur(0);
		System.out.println(cnt);
	}//end main
	static public void recur(int depth) {
		if(depth==N) {
			for(int i=0; i<10; i++) {
				if(check[i]>0) return;
			}
			cnt++;
			return;
		}
		for(int i=0; i<10; i++) {
			check[i]--;
			recur(depth+1);
			check[i]++;
		}
	}
}
