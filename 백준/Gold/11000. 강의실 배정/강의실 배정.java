import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			table[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(table,Comparator.comparingInt(arr -> arr[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(table[0][1]);
		for(int i=1; i<N; i++) {
			if(pq.peek()<=table[i][0]) {
				pq.poll();
			}
			pq.add(table[i][1]);
		}
		System.out.println(pq.size());
	}
}