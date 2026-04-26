import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int pre = 0;
        int mid = 3;
        int now = 3;
        // moo mooo moo / moooo / moo mooo moo
        while(N>now) {
            pre = now;
            mid++;
            now = pre*2 + mid;
        }

        while(true) {
            if(pre<N && N<=pre+mid) {
                N -= pre;
                break;
            }
            else if(N>pre) {
                N-=pre+mid;
                now=pre;
                mid--;
                pre=(now-mid)/2;
            }
            else {
                now=pre;
                mid--;
                pre=(now-mid)/2;
            }
        }
        System.out.println(N==1?"m":"o");
    }//end main
}