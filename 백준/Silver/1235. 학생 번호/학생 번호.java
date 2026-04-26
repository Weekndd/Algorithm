import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        String[] arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }
        int len = arr[0].length();
        for(int i=1; i<=len; i++){
            for(int j=0; j<N; j++){
                set.add(arr[j].substring(len-i));
            }
            if(set.size()==N){
                System.out.println(i);
                break;
            }
            else {
                set.clear();
            }
        }
    }
}