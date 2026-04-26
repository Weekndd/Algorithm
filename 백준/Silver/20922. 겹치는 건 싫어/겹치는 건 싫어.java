import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int maxNum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, arr[i]);
        }

        int[] check = new int[maxNum+1];
        int left = 0;
        int right = 0;
        int ans = 0;
        boolean flag = false;
        while(true) {
            if(right==N) break;

            if(flag) {//현재 right값에 해당하는 요소가 M값을 넘어서 Right로 못움직이는 경우

                if(check[arr[left]]>M) {
                    if(--check[arr[left++]]<=M) flag = false;
                }
                else {
                    --check[arr[left++]];
                }
            }
            else {
                if(check[arr[right++]]++<M) {
                    ans = Math.max(ans, right-left);
                }
                else {
                    flag = true;
                }
            }
        }
        System.out.println(ans);
    }//end main
}