import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		//end input
		int[] a = increase(list);
		Collections.reverse(list);
		int[] b = increase(list);
		
		int result = 0;
		for(int i=0; i<N; i++) {
			result = Math.max(a[i]+b[(N-1)-i]-1,result);
		}
		System.out.println(result);
	}//end main
	public static int[] increase(List<Integer> list) {
		int[] LIS = new int[N];
		int[] seq = new int[N];
		int len = 1;
		LIS[0] = list.get(0);
		seq[0] = 1;
		for(int i=1; i<N; i++) {
			int target = list.get(i);
			if(target>LIS[len-1]) {
				LIS[len] = target;
				len++;
				seq[i] = len;
				continue;
			}
			
			int left = 0;
			int right = len-1;
			while(left<=right) {
				int mid = left+(right-left)/2;
				if(target>LIS[mid]) left = mid+1;
				else right = mid-1;
			}
			//end while
			LIS[left] = target;
			seq[i] = left+1;
		}
		return seq;
	}
}
