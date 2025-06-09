import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] listArr;
    static int N,M;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        listArr = new List[N];
        for(int i=0; i<N; i++) {
        	listArr[i] = new ArrayList<>();
        }//리스트 배열  초기화
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            listArr[A].add(B);
            listArr[B].add(A);
        }
        //end input
        
        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i,1);
            if(flag) break;
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }//end main

    static public void dfs(int idx, int cnt) {
        if(cnt==5) {
            flag = true;
            return;
        }
        for(int i=0; i<listArr[idx].size(); i++) {
        	int nextIdx = listArr[idx].get(i);
            if(visited[nextIdx]) continue;
            visited[nextIdx] = true;
            dfs(nextIdx,cnt+1);
            visited[nextIdx] = false;
            if(flag) break;
        }

    }
}