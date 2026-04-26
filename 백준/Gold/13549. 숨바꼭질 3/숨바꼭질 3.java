import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { //테트로미노
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] value = new int[100001];
        Queue<Integer> que = new LinkedList<>();
        que.offer(A);
        value[A] = 1;
        while(!que.isEmpty()) {
            int now = que.poll();

            int next = now + 1;
            int before = now - 1;
            int teleport = now * 2;

            if(teleport < 100001) {
                if(value[teleport] == 0 || value[teleport]>value[now]) {
                    value[teleport] = value[now];
                    que.offer(teleport);
                }
            }

            if(next < 100001) {
                if(value[next] == 0 || value[next]>value[now]+1) {
                    value[next] = value[now]+1;
                    que.offer(next);
                }
            }

            if(before>=0 && before < 100001) {
                if(value[before] == 0 || value[before]>value[now]+1) {
                    value[before] = value[now]+1;
                    que.offer(before);
                }
            }
        }
        System.out.println(value[B]-1);
    }//end main
}