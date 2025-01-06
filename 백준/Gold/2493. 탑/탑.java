// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int num = arr[i];
            if(stack.isEmpty()) {
                sb.append(0+" ");
            }
            else {
                while(!stack.isEmpty()) {
                    int[] top = stack.peek();
                    if(num < top[0]) break;
                    stack.pop();
                }
                if(stack.size()==0) sb.append(0+" ");
                else sb.append(stack.peek()[1]+" ");
            }
                stack.push(new int[]{num,i+1});
        }
        System.out.println(sb);
        
    }//end main
}