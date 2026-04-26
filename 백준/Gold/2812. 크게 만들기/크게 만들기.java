import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[i]-'0'>stack.peek() && cnt<K) {
                stack.pop();
                cnt++;
            }
            stack.push(arr[i]-'0');
        }
        if(cnt!=K) {
            for(int i=0; i<K-cnt; i++) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(i -> sb.append(i));
        System.out.println(sb);
    }//end main
}
