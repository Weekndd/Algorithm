import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=i; j<=N; j++) {
                sum += j;
                if(sum==N) {
                    ans++;
                    break;
                }
                else if(sum>N) break;
            }
        }
        System.out.println(ans);
    }//end main
}