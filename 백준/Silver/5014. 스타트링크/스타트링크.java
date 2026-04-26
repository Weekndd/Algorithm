import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int top = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] dir = new int[] {Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())};
        int[] visited = new int[top+1];
        boolean flag = false;

        Queue<Integer> que = new LinkedList<>();
        que.offer(now);
        visited[now] = 1;
        while(!que.isEmpty()) {
            int floor = que.poll();
            if(floor == target) {
                flag = true;
                break;
            }
            for(int i=0; i<2; i++) {
                int nextFloor = floor + dir[i];
                if(nextFloor > top) continue;
                if(nextFloor >=1 && visited[nextFloor]==0) {
                    que.offer(nextFloor);
                    visited[nextFloor] = visited[floor]+1;
                }
            }
        }
        if(flag) {
            System.out.println(visited[target]-1);
        }
        else {
            System.out.println("use the stairs");
        }
    }//end main
}