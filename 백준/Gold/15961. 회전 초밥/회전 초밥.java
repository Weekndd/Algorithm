import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //벨트에 놓인 접시 수
        int D = Integer.parseInt(st.nextToken()); //초밥의 가지 수
        int K = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int C = Integer.parseInt(st.nextToken()); //쿠폰 번호
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        //end input
        
        int[] window = new int[K];
        int[] type = new int[D+1];
        
        type[C]++; //쿠폰 초밥 추가
        int cnt = 1; //쿠폰 초밥으로 종류 1로 시작
        for(int i=0; i<K; i++) {
        	if(type[arr[i]]++==0) cnt++;
        }

        int ans = 0;
        int idx = K;
        while(true) {
        	if(idx-K==N) break; //한바퀴 돌고 마지막인덱스 까지 확인했다면
        	int right = idx/N==1? idx%N : idx;

        	if(type[arr[right]]++==0) cnt++;
        	
        	int left = idx-K;
        	if(--type[arr[left]]==0) cnt--;
        	ans = Math.max(ans, cnt);
        	idx++;
        }
        ans = Math.max(ans, cnt);
        System.out.println(ans);
    }//end main
}