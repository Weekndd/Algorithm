import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String strNum = new String();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        strNum += "";
        recur(0);
        System.out.println(sb);
    }//end main

    static public void recur(int depth) {
        if(depth == N) {
            if(!isPrime(Integer.parseInt(strNum))) return;
            sb.append(strNum+"\n");
        }

        for(int i=1; i<=9; i++) {
            strNum += i;
            if(isPrime(Integer.parseInt(strNum))) {
                recur(depth+1);
            }
            strNum = strNum.substring(0,strNum.length()-1);
        }
    }

    public static boolean isPrime(int num) {
        if(num<=1) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3; i<= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}