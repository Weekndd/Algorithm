import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for(int i=0; i<N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
          int num = Integer.parseInt(st.nextToken());
          pq.offer(num);
        }
      }      
      for(int i=0; i<N-1; i++) pq.poll();
      System.out.println(pq.poll());
  }
}