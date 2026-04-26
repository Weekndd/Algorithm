import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list,Collections.reverseOrder());
        list.forEach(i -> sb.append(i+"\n"));
        System.out.println(sb);
    }//end main
}