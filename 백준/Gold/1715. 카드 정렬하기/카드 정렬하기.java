import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
        	pq.add(Long.parseLong(br.readLine()));
        }
        
        long A = 0;
        long B = 0;
        long sum = 0;
        while(!pq.isEmpty()) {
        	A = pq.poll();
        	if(pq.isEmpty()) break;
        	B = pq.poll();
        	sum += A+B;
        	pq.offer(A+B);
        }
        System.out.println(sum);
    }//end main
}
