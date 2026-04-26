import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int AA = Integer.parseInt(br.readLine());
        int BB = Integer.parseInt(br.readLine());
        int bugerMin = Math.min(A,Math.min(B,C));
        int beverageMin = Math.min(AA,BB);
        System.out.println(bugerMin+beverageMin-50);
    }//end main
}