import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = st.nextToken().equals("0")?false:true;
        }

        int students = Integer.parseInt(br.readLine());
        for(int stu=0; stu<students; stu++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int NUM = Integer.parseInt(st.nextToken());
            if(S==1) {
                for(int i=NUM; i<=N; i+=NUM) {
                    arr[i] = !arr[i];
                }
            }
            else {
                arr[NUM] = !arr[NUM];
                int dis = 0;
                while(true) {
                    if(NUM-dis<1 || NUM+dis>N) break;
                    if(arr[NUM+dis]!=arr[NUM-dis]) break;
                    if(arr[NUM+dis] == arr[NUM-dis]) {
                        arr[NUM+dis] = !arr[NUM+dis];
                        arr[NUM-dis] = !arr[NUM-dis];
                    }
                    dis++;
                }//end while
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(arr[i]?1:0).append(" ");
            if((i)%20==0) sb.append("\n");
        }
        System.out.println(sb);
    }//end main
}