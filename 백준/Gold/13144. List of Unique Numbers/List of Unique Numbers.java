import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		boolean[] check = new boolean[100001];
		int left=0, right=0, cnt=0;
		long ans=0;
		while(right<N) {
			if(check[arr[right]]) { //right값이 중복된다면
				check[arr[left++]] = false;
				cnt--;
			}
			else {
				check[arr[right++]] = true;
				cnt++;
				ans += cnt;
			}
		}
		System.out.println(ans);
	}//end main
}
