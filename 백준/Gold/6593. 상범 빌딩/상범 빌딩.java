import java.io.*;
import java.util.*;

public class Main {  //백준 6593번 상범빌딩
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int L = Integer.parseInt(st.nextToken());
        	int R = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	if(L==0 && R==0 && C==0) break;
        	
        	char[][][] arr = new char[L][R][C];
        	int[] start = null;
        	for(int i=0; i<L; i++) {
        		for(int j=0; j<R; j++) {
        			String str = br.readLine();
        			for(int k=0; k<C; k++) {
        				arr[i][j][k] = str.charAt(k);
        				if(arr[i][j][k]=='S') start = new int[] {i,j,k};
        			}
        		}
        		br.readLine();
        	}
        	
        	boolean[][][] checked = new boolean[L][R][C];
        	Queue<int[]> que = new LinkedList<>();
        	que.offer(new int[] {start[0],start[1],start[2],0});
        	checked[start[0]][start[1]][start[2]] = true;
        	
        	int time = 0;
        	int[] dirL = new int[] {-1,1,0,0,0,0};
        	int[] dirR = new int[] {0,0,-1,1,0,0};
        	int[] dirC = new int[] {0,0,0,0,-1,1};
        	while(!que.isEmpty()) {
        		int[] now = que.poll();
        		if(arr[now[0]][now[1]][now[2]]=='E') {
        			time = now[3];
        		}
        		for(int d=0; d<6; d++) {
        			int nl = dirL[d]+now[0];
        			int nr = dirR[d]+now[1];
        			int nc = dirC[d]+now[2];
        			if(nl<0 || nl>=L || nr<0 || nr>=R || nc<0 || nc>=C) continue;
        			if(checked[nl][nr][nc]) continue;
        			if(arr[nl][nr][nc]=='#') continue;
        			checked[nl][nr][nc] = true;
        			que.offer(new int[] {nl,nr,nc,now[3]+1});
        		}
        	}
        	sb.append(time==0?"Trapped!\n":"Escaped in "+time+" minute(s).\n");
        }//end while
        System.out.println(sb);
    }//end main
}