import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] listArr = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
        	listArr[i] = new ArrayList<>();
        }
        int[] arr = new int[N+1];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	arr[B]++;
        	listArr[A].add(B);
        }
        //end input
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        //진입차수가 0인 정점 que에 넣기
        for(int i=1; i<=N; i++) {
        	if(arr[i]==0) {
        		sb.append(i+" ");
        		que.offer(i);
        	}
        }
        while(!que.isEmpty()) {
        	int idx = que.poll();
        	for(int i : listArr[idx]) {
        		arr[i]--;
        		if(arr[i]==0) {
        			sb.append(i+" ");
        			que.offer(i);
        		}
        	}
        }
        System.out.println(sb);
    }//end main
}