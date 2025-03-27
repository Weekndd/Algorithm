import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] type_cnt = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //end input
        if(N==1) { //1이면 바로 종료
            System.out.println(1);
            System.exit(0);
        }

        int left = 0, right = 1;
        int cnt = arr[left]==arr[right] ? 1 : 2;
        type_cnt[arr[left]]++;
        type_cnt[arr[right++]]++;

        int ans = right-left;
        while(right<N) {
            if(cnt>2) { //과일종류가 2개 이상이면
                if(--type_cnt[arr[left++]]==0) cnt--;
                continue;
            }
            else if(type_cnt[arr[right++]]++==0) cnt++;
            if(cnt<=2) ans = Math.max(ans,right-left);
        }
        System.out.println(ans);
    }//end input
}