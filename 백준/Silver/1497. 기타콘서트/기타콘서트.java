import java.io.*;
import java.util.*;

public class Main {
    static int N, M, song, gitar, arr[][];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N][M];
        gitar = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String str = st.nextToken();
            for(int j=0; j<M; j++) {
                char c = str.charAt(j);
                if(c=='Y') arr[i][j] = 1;
            }
        }
        //end input
        subset(0);

        System.out.println(gitar==0? -1 : gitar);

    }//end main
    public static void subset(int start) {
        if(start==N) {
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) continue;
                cnt++;
                for(int j=0; j<M; j++) {
                    if(arr[i][j]==0) continue;
                    set.add(j);
                }
            }
            if(song==set.size()) gitar = Math.min(gitar,cnt);
            else if(song<set.size()) {
                gitar = cnt;
                song = set.size();
            }
        }

        for(int i=start; i<N; i++) {
            visited[i]= true;
            subset(i+1);
            visited[i]= false;
            subset(i+1);
        }

    }//end subset

}