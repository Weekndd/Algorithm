import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<100) {
            System.out.println(N);
            return;
        }
        int cnt = 99;
        for(int i=100; i<=N; i++) {
            char[] strNum = String.valueOf(i).toCharArray();
            int diff = Integer.parseInt(String.valueOf(strNum[0]))-Integer.parseInt(String.valueOf(strNum[1]));
            for(int j=2; j<strNum.length; j++) {
                int A = Integer.parseInt(String.valueOf(strNum[j-1]));
                int B = Integer.parseInt(String.valueOf(strNum[j]));
                if(diff==A-B) cnt++;
            }
        }
        System.out.println(cnt);
    }//end main
}
