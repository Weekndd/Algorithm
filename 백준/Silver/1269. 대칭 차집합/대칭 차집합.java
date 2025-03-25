import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Set<Integer> A = new HashSet<>();
        for(int i=0; i<a; i++) A.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        Set<Integer> B= new HashSet<>();
        for(int i=0; i<b; i++) B.add(Integer.parseInt(st.nextToken()));
        
        int cntA = 0;
        for(int i : A) {
        	if(!B.contains(i)) cntA++;
        }
        int cntB = 0;
        for(int i : B) {
        	if(!A.contains(i)) cntB++;
        }
        System.out.println(cntA+cntB);
    }
}