import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[M];
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[M];
		for(int i=0; i<M; i++) {
			int num = arr[i];
			if(map.containsKey(num)) {
				res[i] = map.get(num);
			} else {
				res[i] = 0;
			}
		}
		for(int i : res) {
			sb.append(i+" ");
		}
		System.out.println(sb);
		
	}
}