import java.util.*;
import java.io.*;

public class Main {
	static int map[][], N, M, dice[][];
	static int[] dirR =  new int[] {0,0,-1,1};
	static int[] dirC =  new int[] {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //지도의 세로크기
        M = Integer.parseInt(st.nextToken()); //지도의 가로크기
        int x = Integer.parseInt(st.nextToken()); //주사위 row좌표
        int y = Integer.parseInt(st.nextToken()); //주사위 col좌표
        int K = Integer.parseInt(st.nextToken()); //명령 수
        
        map = new int[N][M];
        dice = new int[4][3];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        //초기 값 설정
        if(map[x][y]==0) {
        	map[x][y] = dice[3][1];
        }
        else {
        	dice[3][1] = map[x][y];
        	map[x][y] = 0;
        }
        for(int i=0; i<K; i++) {
        	int command = Integer.parseInt(st.nextToken());
        	int nr = x+dirR[command-1];
        	int nc = y+dirC[command-1];
        	if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
        	if(map[nr][nc]==0) {
        		rolldice(command);
        		sb.append(dice[1][1]+"\n");
            	map[nr][nc] = dice[3][1];
            }
            else {
            	rolldice(command);
        		sb.append(dice[1][1]+"\n");
            	dice[3][1] = map[nr][nc];
            	map[nr][nc] = 0;
            }
        	x = nr; 
        	y = nc;
        }
        System.out.println(sb);
        
    }//end main
    
    static void rolldice(int command) {
    	if(command==1) {
    		int temp = dice[3][1];
    		dice[3][1] = dice[1][2];
    		dice[1][2] = dice[1][1];
    		dice[1][1] = dice[1][0];
    		dice[1][0] = temp;
    	}
    	else if(command==2) {
    		int temp = dice[3][1];
    		dice[3][1] = dice[1][0];
    		dice[1][0] = dice[1][1];
    		dice[1][1] = dice[1][2];
    		dice[1][2] = temp;
    	}
		else if(command==3) {
			int temp = dice[0][1];
    		dice[0][1] = dice[1][1];
    		dice[1][1] = dice[2][1];
    		dice[2][1] = dice[3][1];
    		dice[3][1] = temp;
		}
		else if(command==4) {
			int temp = dice[3][1];
    		dice[3][1] = dice[2][1];
    		dice[2][1] = dice[1][1];
    		dice[1][1] = dice[0][1];
    		dice[0][1] = temp; 
		}
    }
}