import java.io.*;
import java.util.*;
//백준 1202 보석도둑
public class Main {
    static class Dia {
        int price;
        int weight;
        public Dia(int weight, int price) {
            this.price = price;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //보석 수
        int K = Integer.parseInt(st.nextToken()); //가방 수
        PriorityQueue<Dia> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        PriorityQueue<Dia> dias = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        int[] bags = new int[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int wei = Integer.parseInt(st.nextToken());
            int pri = Integer.parseInt(st.nextToken());
            dias.offer(new Dia(wei,pri));
        }

        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        long max = 0;
        for(int i=0; i<K; i++) {
            int bag = bags[i];
            while(!dias.isEmpty() && bag>=dias.peek().weight) {
                pq.offer(dias.poll());
            }
            if(!pq.isEmpty()) {
                max += pq.poll().price;
            }
        }
        System.out.println(max);

    }//end main
}
