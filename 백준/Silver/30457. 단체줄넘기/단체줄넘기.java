import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		boolean[] check = new boolean[N];
		int cnt = 0;
		int pre = 0;
		for(int i=0; i<N; i++) {
			int num = arr[i];
			if(num>pre) {
				cnt++;
				pre = num;
				check[i] = true;
			}
		}
		pre = 1001;
		for(int i=N-1; i>=0; i--) {
			if(check[i]) continue;
			int num = arr[i];
			if(num<pre) {
				cnt++;
				pre = num;
			}
		}
		System.out.println(cnt);
	}//end main
}
