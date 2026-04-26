import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int n=0; n<5; n++) {
            int num = Integer.parseInt(br.readLine());
            sum = num < 40 ? sum+40 : sum+num;
        }
        System.out.println(sum/5);
    }
}
