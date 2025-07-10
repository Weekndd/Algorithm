import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 100000;
        boolean[] visited = new boolean[max+1];
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);

        que.offer(new int[] {N,0});
        int cnt = 0;
        int minTime = Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            int[] now = que.poll();
            int nowN = now[0];
            int time = now[1];
            if(nowN==K) {
                if(minTime>time) {
                    minTime = time;
                    cnt = 1;
                }
                else if(minTime==time) cnt++;
            }
            visited[nowN] = true;

            int nextA = nowN-1;
            int nextB = nowN+1;
            int nextC = nowN*2;
            if(nextC<=max && !visited[nextC]) que.offer(new int[]{nextC, time+1});
            if(nextB<=max && !visited[nextB]) que.offer(new int[]{nextB, time+1});
            if(nextA>=0 && !visited[nextA]) que.offer(new int[]{nextA, time+1});
        }
        System.out.println(minTime);
        System.out.println(cnt);
    }//end main
}