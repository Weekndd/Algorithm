import java.util.*;
import java.io.*;

class Main {
	static class Move implements Comparable<Move>{
		int sec;
		String direction;
		Move(int sec, String direction) {
			this.sec = sec;
			this.direction = direction;
		}
		public int compareTo(Move o1) {
			return this.sec - o1.sec;
		}
	}
	static int N, K, L, map[][];
	static int[] dirR = new int[]{0,1,0,-1};
	static int[] dirC = new int[]{1,0,-1,0};
	static PriorityQueue<Move> moving = new PriorityQueue<>(); 
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=0; i<K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	map[r][c] = 1;
        }
        
        
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int sec = Integer.parseInt(st.nextToken());
        	String direction = st.nextToken();
        	moving.add(new Move(sec, direction));
        }
        //end input;
        
        int time = 0;
        Queue<int[]> que = new LinkedList<>(); //다음 진행경로
        que.offer(new int[] {1,1,0});
        map[1][1] = 2;
        Queue<int[]> body = new LinkedList<>(); //몸
        body.offer(new int[] {1,1});
        
        while(!que.isEmpty()) {
        	
        	int[] now = que.poll();
        	int dir = now[2];
        	//다음 방향확인(이미 모든 방향을 다 바꿨으면 pass)
        	if(!moving.isEmpty()) {
        		Move move = moving.peek();
            	if(time==move.sec) {
            		moving.poll();
            		if(move.direction.equals("L")) dir = (now[2]-1+4)%4;
            		else dir = (now[2]+1+4)%4;
            	}
        	}
        	int nr = now[0] + dirR[dir];
        	int nc = now[1] + dirC[dir];
        	if(nr<=0 || nr>N || nc<=0 || nc>N) break;
        	if(map[nr][nc] == 2) break; //뱀의 몸에 닿으면
        	if(map[nr][nc] == 0) { //맨 땅이면 몸길이 그대로
        		int[] tail = body.poll();
        		map[tail[0]][tail[1]] = 0;
        	}
        	map[nr][nc] = 2;
        	body.offer(new int[] {nr,nc});
        	que.offer(new int[] {nr,nc,dir});
        	time++;
        }
        
        System.out.println(time+1);
    }//end main
}