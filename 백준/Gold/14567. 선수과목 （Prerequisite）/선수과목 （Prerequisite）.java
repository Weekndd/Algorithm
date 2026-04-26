import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[B]++;
            list[A].add(B);
        }
        Queue<int[]> que = new LinkedList<>();
        int[] ans = new int[N+1];
        for(int i=1; i<=N; i++) {
            if(arr[i]==0) {
                ans[i] = 1;
                que.offer(new int[]{i,1});
            }
        }

        while(!que.isEmpty()) {
            int[] now = que.poll();
            int idx = now[0];
            int cnt = now[1];
            for(int i=0; i<list[idx].size(); i++) {
                int next = list[idx].get(i);
                if(--arr[next]==0) {
                    ans[next] = cnt+1;
                    que.offer(new int[]{next,cnt+1});
                }
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(ans[i]+" ");
        }
    }//end main
}