import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		Map<String,PriorityQueue<Integer>> map = new HashMap<>();
		
		long totalValue = 0;
		for(int q=0; q<Q; q++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			
			String gorila = st.nextToken();
			PriorityQueue<Integer> pq = map.get(gorila);
			
			if(command == 1) { //정보 추가
				int infoCnt = Integer.parseInt(st.nextToken());
				
				if(pq==null) { //새로운 정보상인이면 상인등록
					pq = new PriorityQueue<>((o1,o2)-> o2-o1);
					map.put(gorila, pq);
				}
				for(int i=0; i<infoCnt; i++) {
					int info = Integer.parseInt(st.nextToken());
					pq.offer(info);
				}
			}
			else { //정보 구매
				if(pq==null) continue; //없는 상인이면
				int infoCnt = Integer.parseInt(st.nextToken());
				for(int i=0; i<infoCnt; i++) {
					if(pq.isEmpty()) break;
					totalValue += pq.poll();
				}
			}
		}//쿼리 끝
		System.out.println(totalValue);
	}//end main
}
