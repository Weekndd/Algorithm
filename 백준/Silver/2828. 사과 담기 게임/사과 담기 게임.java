import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int left = 1;
		int right = left+M-1;
		int ans = 0;
		
		int A = Integer.parseInt(br.readLine());
		for(int i=0; i<A; i++) {
			int a = Integer.parseInt(br.readLine());
			if(left<=a && a<=right) continue;
			if(left>a) {
				ans += left - a;
				left = a;
				right = left+M-1;
			}
			else if(right<a) {
				ans += a-right;
				right = a;
				left = right-M+1;
			}
		}
		System.out.println(ans);
    }
}