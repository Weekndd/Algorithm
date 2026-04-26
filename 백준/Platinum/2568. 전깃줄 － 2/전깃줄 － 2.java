import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[500001];
		int startIdx = 500001;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A] = B;
			startIdx = Math.min(startIdx,A);
		}
		//end input
		
		int[] LIS = new int[500001];
		int[] seq = new int[500001];
		int len = 1;
		LIS[0] = arr[startIdx];
		seq[startIdx] = 1;
		
		for(int i=startIdx+1; i<=500000; i++) {
			int target = arr[i];
			if(target==0) continue;
			if(LIS[len-1]<target) {
				LIS[len] = target;
				seq[i] = ++len;
				continue;
			}
			
			int left = 0;
			int right = len-1;
			while(left<=right) {
				int mid = left+(right-left)/2;
				
				if(target>LIS[mid]) left = mid+1;
				else right = mid-1;
				
			}//end while
			LIS[left] = target;
			seq[i] = left+1;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(N-len+"\n");
		int temp = len;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=500000; i>=0; i--) {
			if(seq[i]==0) continue;
			if(seq[i]==temp) temp--;
			else list.add(i);
		}
		Collections.reverse(list);
		for(int i : list) sb.append(i+"\n");
		System.out.println(sb);
	}//end main
}
