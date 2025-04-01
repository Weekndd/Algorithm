import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char command[],map[][];
	static boolean light[][], zombie[][], flag;
	static List<int[]> zombies = new ArrayList<>();
	static int[] dirR = new int[] {-1,0,1,0,1,-1,1,-1};
	static int[] dirC = new int[] {0,1,0,-1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        command = br.readLine().toCharArray();
        zombie = new boolean[N][N];
        map = new char[N][N];
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	for(int j=0; j<N; j++) {
        		map[i][j] = str.charAt(j);
        		if(map[i][j]=='Z') {
        			zombies.add(new int[] {i,j,2});
        			zombie[i][j] = true;
        		}
        	}
        }//end input
        light = new boolean[N][N];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0,2,0}); //r,c,d,time
        int[] now = new int[4];
        while(!que.isEmpty()) {
        	now = que.poll();
        	int r = now[0];
        	int c = now[1];
        	
        	if(now[3]>=command.length) break; //커맨드를 다 수행했다면 끝
        	if(map[r][c] == 'S') turnOnLight(r, c); //스위치면 불켜기
        	if(checkZombie(now)) break;
        	if(now[3]>0) moveZombie();
        	if(checkZombie(now)) break;
        	int nd = now[2];
        	if(command[now[3]]=='R') nd = (now[2]+1) % 4;
        	else if(command[now[3]]=='L') nd = (now[2]+3) % 4;
        	else if(command[now[3]]=='F') {
        		nd = now[2];
        		int nr = now[0]+dirR[nd];
            	int nc = now[1]+dirC[nd];
            	if(nr<0 || nr>=N || nc<0 || nc>=N) {
            		que.offer(new int[] {r, c, nd, now[3]+1});
            	}
            	else que.offer(new int[] {nr,nc,nd,now[3]+1});
            	continue;
        	}
        	que.offer(new int[] {r,c,nd,now[3]+1});
        }
        System.out.println(flag ? "Aaaaaah!" : "Phew...");
    }
    static void turnOnLight(int r, int c) {
    	light[r][c] = true;
    	for(int i=0; i<8; i++) {
    		int nr = r+dirR[i];
    		int nc = c+dirC[i];
    		if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
    		light[nr][nc] = true;
    	}
    }
    static void moveZombie() {
    	zombie = new boolean[N][N];
    	List<int[]> nextZombies = new ArrayList<>(); 
    	for(int[] zom : zombies) {
    		int nr = zom[0]+dirR[zom[2]];
    		int nc = zom[1]+dirC[zom[2]];
    		int nd = zom[2];
    		if(nr<0 || nr>=N || nc<0 || nc>=N) {
    			nd = (nd+2) % 4;
    			zombie[zom[0]][zom[1]] = true;
    			nextZombies.add(new int[] {zom[0], zom[1], nd});
    			continue;
    		}
    		zombie[nr][nc] = true;
    		nextZombies.add(new int[] {nr,nc,nd});
    	}
    	zombies = nextZombies;
    }
    static boolean checkZombie(int[] now) {
    	int r= now[0];
    	int c= now[1];
    	if(light[r][c]==false && zombie[r][c]==true) { //불이 꺼져있으면서 좀비랑 만나면
    		flag = true;
    		return true;
    	}
    	return false;
    }
}