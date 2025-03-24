import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static char[][] arr;
	static boolean[] lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
        	
        	N = Integer.parseInt(br.readLine());
        	String str = br.readLine();
        	K = str.length();
        	arr = new char[N+1][K+1];
        	arr[1] = str.toCharArray();
        	for(int i=2; i<=N; i++) {
        		arr[i] = br.readLine().toCharArray();
        	}
        	
        	lose = new boolean[N+1];
        	for(int i=0; i<K; i++) {
        		if(isDraw(i)) continue;
        		winner(i);
        	}
        	sb.append(findWinner()+"\n");
        }//end test
        System.out.println(sb);
    }//end main
    
    public static boolean isDraw(int col) {
    	int r=0 ,c=0 ,p=0;
    	int person = 0;
    	for(int i=1; i<=N; i++) {
    		if(lose[i]) continue;
    		person++;
    		if(arr[i][col]=='R') r++;
    		else if(arr[i][col]=='S') c++;
    		else if(arr[i][col]=='P') p++;
    	}
    	if(r>0 && c>0 && p>0) return true;
    	if(r==person || c==person || p==person) return true;
    	else return false;
    }
    
    public static void winner(int col) {
    	List<Integer> r = new ArrayList<>();
    	List<Integer> s = new ArrayList<>();
    	List<Integer> p = new ArrayList<>();
    	for(int i=1; i<=N; i++) {
    		if(lose[i]) continue;
    		if(arr[i][col]=='R') r.add(i);
    		else if(arr[i][col]=='S') s.add(i);
    		else if(arr[i][col]=='P') p.add(i);
    	}
    	
    	if(r.isEmpty()) {
    		for(int i : p) lose[i] = true;
    	}
    	else if(s.isEmpty()) {
    		for(int i : r) lose[i] = true;
    	}
    	else if(p.isEmpty()) {
    		for(int i : s) lose[i] = true;
    	}
    }
    public static int findWinner() {
    	int cnt = 0;
    	int winner = 0;
    	for(int i=1; i<=N; i++) {
    		if(lose[i]) continue;
    		winner = i;
    		cnt++;
    	}
    	if(cnt>1 || cnt==0) return 0; 
    	return winner;
    }
}