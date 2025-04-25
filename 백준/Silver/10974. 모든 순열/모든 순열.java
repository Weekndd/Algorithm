import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N+1];
        combination(1,"");
        System.out.println(sb);
    }
    static public void combination(int now, String combi) {
        if(now>N) {
            sb.append(combi+"\n");
            return;
        }
        for(int i=1; i<=N; i++) {
            if(check[i]) continue;
            check[i] = true;
            combination(now+1, combi+i+" ");
            check[i] = false;
        }
    }
}