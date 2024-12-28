import java.util.*;
import java.io.*;

public class Main {
	static int N,map[][];
	static int MIN = Integer.MAX_VALUE;
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        check = new boolean[N][N];
        backtracking(0,0,0,0);
        System.out.println(MIN);
        
    }//end main
    static void backtracking(int depth, int r, int c, int cost) { //{R,C,price}
    	if(depth==3) {
    		MIN = Math.min(cost,MIN);
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(check[i][j]) continue;
        		boolean flag = false;
        		//꽃이 필 수 있는 자리인지 확인
        		for(int d=0; d<4; d++) {
            		int nr = i + dirR[d];
            		int nc = j + dirC[d];
            		if(nr<0 || nr>=N || nc<0 || nc>=N || check[nr][nc]) {
            			flag = true;
            			break;
            		}
            	}
        		
            	if(!flag) {
            		int tempCost = cost + map[i][j];
            		check[i][j] = true;
            		for(int d=0; d<4; d++) {
                		int nr = i + dirR[d];
                		int nc = j + dirC[d];
                		check[nr][nc] = true;
                		tempCost += map[nr][nc];
                	}
            		backtracking(depth+1, i, j, tempCost);
            		for(int d=0; d<4; d++) {
                		int nr = i + dirR[d];
                		int nc = j + dirC[d];
                		check[nr][nc] = false;
                	}
            		check[i][j] = false;
            	}
        	}
        }
    	
    }
}