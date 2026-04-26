import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		int[] card = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			int num = card[i];
			int lo = 0;
			int hi = arr.length-1;
			int mid = 0;
			boolean flag = false;
			
			while(lo<=hi) {
				mid = (lo+hi)/2;
				if(num<arr[mid]) {
					hi = mid-1;
				}
				else if(num == arr[mid]){
					flag = true;
					break;
				}
				else if(num>arr[mid]) {
					lo = mid+1;
				}
			}//end while
			if(flag == true) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
		}//end for
		System.out.println(sb);
	}//end main
}