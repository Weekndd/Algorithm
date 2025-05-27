import java.io.*;
import java.util.*;

public class Main {
	static char[][] originMap;
	static boolean check[][], flag;
	static int cnt = 0;
	static int[] dirR = new int[] {0,0,-1,1};
	static int[] dirC = new int[] {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        originMap = new char[12][6];
        for(int i=0; i<12; i++) {
        	originMap[i] = br.readLine().toCharArray();
        }
        
        while(true) {
        	List<int[]> removeList = checkPuyo(originMap);
        	remove(removeList);
        	move();
        	if(!flag) break;
        	cnt++;
        }
        System.out.println(cnt);
    }//end main
    static void remove(List<int[]> removeList) {
    	for(int[] i : removeList) {
    		originMap[i[0]][i[1]] = '.';
    	}
    }
    
    static void move() {
    	for(int j=0; j<6; j++) {
    		for(int i=11; i>=0; i--) {
    			if(originMap[i][j]=='.') continue;
    			if(i+1>=12 || originMap[i+1][j]!='.') continue;
    			
    			Queue<int[]> que = new LinkedList<>();
    			que.offer(new int[] {i,j});
    			while(!que.isEmpty()) {
    				int[] now = que.poll();
    				int nr = now[0]+1;
    				if(nr>=12 || originMap[nr][now[1]]!='.') {
    					originMap[now[0]][now[1]] = originMap[i][j];
    					originMap[i][j] = '.';
    					continue;
    				}
    				else {
    					que.offer(new int[] {nr,now[1]});
    				}
    			}
        	}
    	}
    	
    }
    
    static public List<int[]> checkPuyo(char[][] map) {
    	flag = false; //여러 그룹의 뿌요를 확인하기 위한 boolean
    	check = new boolean[12][6];
    	List<int[]> allRemoveList = new ArrayList<>();
    	for(int i=0; i<12; i++) {
    		for(int j=0; j<6; j++) {
    			if(map[i][j]=='.') continue;
    			if(check[i][j]) continue;
    			List<int[]> removeList = checkColor(map[i][j], i, j);
    			if(removeList==null) continue;
    			if(removeList.size()>=4) {
    				flag = true;
    				for(int[] e : removeList) {
    					check[e[0]][e[1]] = true;
    					allRemoveList.add(e);
    				}
    			}
    		}//end for
    	}
    	return allRemoveList;
    }
    static public List<int[]> checkColor(char color, int r, int c) {

    	List<int[]> list = new ArrayList<>();
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {r,c});
    	list.add(new int[] {r,c});
    	check[r][c] = true;
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		for(int d=0; d<4; d++) {
    			int nr = now[0] + dirR[d];
    			int nc = now[1] + dirC[d];
    			if(nr<0 || nr>=12 || nc<0 || nc>=6) continue;
    			if(check[nr][nc]) continue;
    			if(originMap[nr][nc]==color) {
    				que.offer(new int[] {nr,nc});
    				list.add(new int[] {nr, nc});
    				check[nr][nc] = true;
    			}
    		}
    	}
    	if(list.size()>=4) return list;
    	else return null;
    }//end checkColor
}