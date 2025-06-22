import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int rain = 0;
		int pre = arr[0];
		for(int i=1; i<M-1; i++) {
			int now = arr[i];
			if(pre<=now) {
				pre = now;
				continue;
			}
			int max = 0;
			for(int j=i+1; j<M; j++) {
				max = Math.max(arr[j],max);
			}
			if(now>=max) continue;
			rain += Math.min(pre, max)-now;
			pre = Math.max(now, pre);
		}
		System.out.println(rain);
	}//end main
}
