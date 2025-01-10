import java.util.*;
import java.io.*;

class Main {
    static class Beer implements Comparable<Beer>{
        int level, satisfy;
        Beer(int level, int satisfy) {
            this.level = level;
            this.satisfy = satisfy;
        }
        public int compareTo(Beer o1) {
            if(o1.level == this.level) return o1.satisfy - this.satisfy;
            return this.level - o1.level;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //축제기간
        int M = Integer.parseInt(st.nextToken()); //선호도 합
        int K = Integer.parseInt(st.nextToken()); // 맥주 종류
        
        Beer[] beers = new Beer[K];
        int max = 0;
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int satisfy = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            beers[i] = new Beer(level, satisfy);
            max = Math.max(max, level);
        }
        Arrays.sort(beers);
        Queue<Integer> pq = new PriorityQueue<>();
        
        int total = 0;
        int ans = -1;
        for(Beer beer : beers) {
        	pq.offer(beer.satisfy);
        	total += beer.satisfy;
        	
        	if(pq.size()>N) {
        		int satisfy = pq.poll();
        		total -= satisfy;
        	}
        	if(pq.size()==N && total>=M) {
        		ans = beer.level;
        		break;
        	}
        }
        System.out.println(ans);
    }//end main
}