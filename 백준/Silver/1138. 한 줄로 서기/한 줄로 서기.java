import java.util.*;
import java.io.*;

public class Main {
	static int N, arr[], combiArr[];
	static boolean check[], flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		combiArr = new int[N+1];
		check = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		combi(1);
	}//end main
	static public void combi(int depth) {
		if(depth==N+1) {
			for(int i=1; i<=N; i++) {
				int num = combiArr[i];
				int cnt = 0;
				for(int j=1; j<i; j++) {
					if(num<combiArr[j]) cnt++;
				}//end j for
				if(arr[num]!=cnt) return;
			}
			flag = true;
			for(int i=1; i<=N; i++) {
				System.out.print(combiArr[i]+" ");
			}
			return;
		}
		for(int i=1; i<=N; i++) {
			if(check[i]) continue;
			check[i] = true;
			combiArr[i] = depth;
			combi(depth+1);
			if(flag) break;
			check[i] = false;
		}
	}
}
