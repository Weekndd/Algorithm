import java.io.*;
import java.util.*;

public class Main {
	public static class Board {
		int num;
		int copy;
		int cnt;
		Board(int num, int cnt, int copy) {
			this.num = num;
			this.copy = copy;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		Queue<Board> que = new LinkedList<Board>();
		int[][] visited = new int[2001][2001];
		
		for(int i=1; i<2001; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		que.offer(new Board(1,0,0));
		int res = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Board now = que.poll();
			// 가장 적은 카운트의 답인지 확인
			if(now.num==S) res = res > now.cnt ? now.cnt : res;
			
			int nextCnt = now.cnt +1;
			int pasted = now.num + now.copy;
			int del = now.num - 1;
			// 붙여넣는 경우
			if(now.copy!=0 && pasted <= 2000 && visited[pasted][now.copy] > nextCnt) {
				visited[pasted][now.copy] = nextCnt;
				que.offer(new Board(pasted, nextCnt, now.copy));
			}
			// 1개 삭제하는 경우
			if(del > 1 && visited[del][now.copy] > nextCnt) {
				visited[del][now.copy] = nextCnt;
				que.offer(new Board(del, nextCnt, now.copy));
			}
			// 복사만 하는 경우
			if(now.num <= 2000 && visited[now.num][now.num] > nextCnt) {
				que.offer(new Board(now.num, nextCnt, now.num));
				visited[now.num][now.num] = nextCnt;
			}
		}
		System.out.println(res);
	}
}
