import java.io.*;
import java.util.*;

public class Main {
	static int[] dirR = new int[] {-1,1,0,0};
	static int[] dirC = new int[] {0,0,-1,1};
	static int N, M, totalVirusCnt, spaceCnt, originMap[][];
	static int result = 5000;
	static List<Virus> VList = new ArrayList();
	static class Virus {
		int r, c;
		Virus(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		originMap = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int el = Integer.parseInt(st.nextToken());
				if(el==2) VList.add(new Virus(i,j));
				else if(el==0) spaceCnt++;
				originMap[i][j] = el; 
			}
		}
		totalVirusCnt = VList.size();
		// 초기 빈칸이 없는경우
		if(spaceCnt==0) {
			System.out.println(0);
			return;
		}
		pickVirus(0, 0, new int[M]);
		System.out.println(result==5000 ? -1 : result);
	}//end main
	
	//combination
	static public void pickVirus(int start, int depth, int[] picked) {
		if(depth == M) {
			List<Virus> virusList = new ArrayList<>();
			for(int i=0; i<M; i++) {
				virusList.add(VList.get(picked[i]));
			}
			moveVirus(virusList);
			return;
		}
		for(int i=start; i<totalVirusCnt; i++) {
			picked[depth] = i;
			pickVirus(i+1, depth+1, picked);
		}
	}
	static public void moveVirus(List<Virus> virusList) {
		Queue<Virus> que = new LinkedList<>(virusList);
		int[][] newMap = copyMap(virusList);
		int virusCnt = 0;
		loop:
		while(!que.isEmpty()) {
			Virus now = que.poll();
			for(int d=0; d<4; d++) {
				int nr = now.r+dirR[d];
				int nc = now.c+dirC[d];
				int nCnt = newMap[now.r][now.c]+1;
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(newMap[nr][nc]==-2) {
//					newMap[nr][nc] = newMap[now.r][now.c];
					virusCnt++;
					newMap[nr][nc] = nCnt;
					que.offer(new Virus(nr,nc));
					continue;
				}
				//벽이면 패스 || 다음cnt가 더 크거나 같으면 패스
				if(newMap[nr][nc]==-1 || nCnt>=newMap[nr][nc]) continue;
				newMap[nr][nc] = nCnt;
				que.offer(new Virus(nr,nc));
				if(isAllVirus(newMap)) {
					break loop;
				}
			}
		}//end while
		checkMap(newMap);
	}
	
	//util
	static public int[][] copyMap(List<Virus> virusList) {
		int[][] copiedMap = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int el = originMap[i][j];
				if(el == 1) copiedMap[i][j] = -1;
				else if(el == 2) copiedMap[i][j] = -2;
				else copiedMap[i][j] = 5000; //MAX_VALUE;
			}
		}
		for(int i=0; i<virusList.size(); i++) {
			Virus v = virusList.get(i);
			copiedMap[v.r][v.c] = 0;
		}
		return copiedMap;
	}
	
	static public void checkMap(int[][] map) {
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int el = map[i][j];
				if(el == 5000) return;
				else max = max < el ? el : max;
			}
		}
		result = result < max ? result : max;
	}
	static public boolean isAllVirus(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int el = map[i][j];
				if(el == 5000) return false;
			}
		}
		return true; 
	}
}
