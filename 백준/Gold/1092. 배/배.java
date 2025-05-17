import java.util.*;
import java.io.*;

public class Main {
	static int min = Integer.MAX_VALUE, youmi[], people[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] cranes = new Integer[N];
		for(int i=0; i<N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		Integer[] boxes = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cranes, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());
		if(boxes[0]>cranes[0]) {
			System.out.println(-1);
			return;
		}
		
		boolean[] check = new boolean[M];
		int cnt = 0;
		int ans = 0;
		int[] craneStartPoint = new int[N];
		while(true) {
			if(cnt==M) break;
			for(int i=0; i<N; i++) { //크레인 순회
				int crane = cranes[i];
				for(int j=craneStartPoint[i]; j<M; j++) { //박스 순회
					if(check[j]) continue;
					int box = boxes[j];
					
					if(crane-box>=0) {  
						cnt++;
						check[j] = true;
						break;
					} else {
						craneStartPoint[i]++;;
					}
				}				
			}
			ans++;
		}
		System.out.println(ans);
	}//end main
}
