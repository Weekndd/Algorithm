import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i : list) sb.append(i).append(" ");
        System.out.println(sb);
    }
}
