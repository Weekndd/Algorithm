import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	pq.offer(num);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	pq.offer(num);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	sb.append(pq.poll()+" ");
        }
        System.out.println(sb);
    }//end main
}