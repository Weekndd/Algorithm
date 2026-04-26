import java.util.*;
import java.io.*;

public class Main {
    static int[] parent, power;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        power = new int[N+1];
        for(int i=1; i<=N; i++) {
            power[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(operation==1) {
                union(A,B);
            }
            else if(operation==2) {
                fight(A,B);
            }
        }//end operation
        List<Integer> country = new ArrayList<>();
        for(int i : power) {
            if(i==0) continue;
            country.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(country.size()+"\n");
        Collections.sort(country);
        for (int i: country) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }//end main

    static public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        if(rootA>rootB) {
            parent[rootA] = rootB;
            power[rootB] += power[rootA];
            power[rootA] = 0;
        }
        else {
            parent[rootB] = rootA;
            power[rootA] += power[rootB];
            power[rootB] = 0;
        }
        return true;
    }
    static public int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    public static void fight(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        if(power[rootA] == power[rootB]) { //병력이 같으면 둘 다 멸망
            power[rootA] = 0;
            power[rootB] = 0;
        }
        else if(power[rootA]>power[rootB]) { //병력이 작은 쪽은 속국이 된다.
            power[rootA] -= power[rootB];
            power[rootB] = 0;
            parent[rootB] = rootA;
        }
        else {
            power[rootB] -= power[rootA];
            power[rootA] = 0;
            parent[rootA] = rootB;
        }
    }
}
