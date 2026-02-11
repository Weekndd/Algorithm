import java.io.*;
import java.util.*;

public class Main {
	public static class FireBall {
		int r, c, m, s, d;
		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	static int[] dirR = {-1,-1,0,1,1,1,0,-1};
	static int[] dirC = {0,1,1,1,0,-1,-1,-1};
	static int N, M, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ArrayList<FireBall>[][] fireBalls = init();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls[r][c].add(new FireBall(r,c,m,s,d));
		}
		
		//파이어볼 K만큼 이동
		for(int i=0; i<K; i++) {
			// 파이어볼 이동
			ArrayList<FireBall>[][] newFireBalls = move(fireBalls);
			// 파이어볼 합치고 분해
//			ArrayList<FireBall>[][] mergedFireBalls = mergeAndDivide(newFireBalls);
			// while 분해된 파이어볼 다시 합치고 분해?
			fireBalls = newFireBalls;
		}
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(fireBalls[i][j].size()==0) continue;
				for(int k=0; k<fireBalls[i][j].size(); k++) {
					result += fireBalls[i][j].get(k).m;
				}
			}
		}
		System.out.println(result);
	} //end main
	
	static public ArrayList<FireBall>[][] init() {
		ArrayList<FireBall>[][] fireBalls= new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            fireBalls[i][j] = new ArrayList<>();
	        }
	    }
		return fireBalls;
	}//end init
	
	static public ArrayList<FireBall>[][] move(ArrayList<FireBall>[][] fireBalls) {
		ArrayList<FireBall>[][] newFireBalls = init();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(fireBalls[i][j].size()==0) continue;
				else if(fireBalls[i][j].size()==1) {
					FireBall nowFireBall = fireBalls[i][j].get(0);
					int nextR = Math.floorMod(nowFireBall.r + dirR[nowFireBall.d] * nowFireBall.s, N);
					int nextC = Math.floorMod(nowFireBall.c + dirC[nowFireBall.d] * nowFireBall.s, N);
					newFireBalls[nextR][nextC].add(new FireBall(nextR,nextC,nowFireBall.m, nowFireBall.s, nowFireBall.d));
				}
				else {
					for(int k=0; k<fireBalls[i][j].size(); k++) {
						FireBall nowFireBall = fireBalls[i][j].get(k);
						int nextR = nowFireBall.r;
						int nextC = nowFireBall.c;
						newFireBalls[nextR][nextC].add(new FireBall(nextR,nextC,nowFireBall.m, nowFireBall.s, nowFireBall.d));
					}
				}
			}
		}
		if(checkFireBall(newFireBalls)) {
			newFireBalls = mergeAndDivide(newFireBalls);
		}
		return newFireBalls;
	}
	
	static public ArrayList<FireBall>[][] mergeAndDivide(ArrayList<FireBall>[][] fireBalls) {
		ArrayList<FireBall>[][] newFireBalls = init();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 1개만 있으면 그대로
				if(fireBalls[i][j].size()==1) {
					newFireBalls[i][j].add(new FireBall(fireBalls[i][j].get(0).r, fireBalls[i][j].get(0).c, fireBalls[i][j].get(0).m, fireBalls[i][j].get(0).s, fireBalls[i][j].get(0).d));
				}
				else if(fireBalls[i][j].size()>=2) {
					int mergedM = 0;
					int mergedS = 0;
					boolean isSameDir = checkDir(fireBalls[i][j]);
					for(int k=0; k<fireBalls[i][j].size(); k++) {
						mergedM += fireBalls[i][j].get(k).m;
						mergedS += fireBalls[i][j].get(k).s;
					}
					mergedM = mergedM/5;
					mergedS = mergedS/fireBalls[i][j].size();
					// 질량 0이면 사라짐8
					if(mergedM==0) continue;
					// 나눠지는 파이어볼
					for(int d=isSameDir?0:1; d<8; d=d+2) {
						int nextR = Math.floorMod(i + dirR[d] * mergedS, N);
						int nextC = Math.floorMod(j + dirC[d] * mergedS, N);
						newFireBalls[i][j].add(new FireBall(nextR, nextC, mergedM, mergedS, d));
					}
				}
				
				
			}
		}
		return newFireBalls;
	}
	
	static public boolean checkDir(ArrayList<FireBall> fireBalls) {
		int odd = 0;
		int even = 0;
		for(int i=0; i<fireBalls.size(); i++) {
			int dir = fireBalls.get(i).d % 2;
			if(dir==0) even++; 
			else odd++;
		}
		if(odd>0 && even>0) return false;
		else return true; 
	}
	
	static public boolean checkFireBall(ArrayList<FireBall>[][] fireBalls) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(fireBalls[i][j].size()>=2) return true;
			}
		}
		return false; 
	}
}
