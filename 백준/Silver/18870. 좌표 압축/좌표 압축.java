import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			res[i] = num;
		}
		
		Arrays.sort(arr);
		int index = 0;
		
		for(int i=0; i<N; i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			else {
				map.put(arr[i],index);
				index++;
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(res[i])+" ");
		}
		System.out.println(sb);
		
	}//end main
}