import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        double A = N*0.22;
        double B = N*0.22*0.2;
        sb.append((int)(N-A)+" "+(int)(N-B));
        System.out.println(sb);
    }
}