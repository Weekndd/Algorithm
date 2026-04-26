import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }//end input
        boolean[] visited = new boolean[N+1];
        int[] count = new int[N+1];

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        count[1] = 0;
        visited[1] = true;
        while(!que.isEmpty()) {
            int ver = que.poll();
            List<Integer> node = list.get(ver);

            for(int next : node) {
                if(!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                    count[next] = count[ver] + 1;
                }
            }
        }

        int maxIdx = 0;
        int maxCount = 0;
        int sameCount = 0;
        for(int i=1; i<=N; i++) {
            if(count[i] > maxCount) {
                maxCount = count[i];
                maxIdx = i;
                sameCount = 1;
            }
            else if(maxCount == count[i]) sameCount++;
        }
        System.out.println(maxIdx+" "+ maxCount +" "+ sameCount);
    }//end main

}