import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int[] parent;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		//parent배열 초기화
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(a,b);
			}
			else {
				sb.append(isSameParent(a,b)? "YES\n" : "NO\n");
			}
		}
		System.out.println(sb);
		
	}//end Main	
	
	private static void union(int a, int b) {
		//a와 b의 부모를 찾는다.
		a = find(a);
		b= find(b);
		
		//만약 a와 b의 부모가 다르다면, b의 부모를 a로 연결  / 부모가 같다면 넘어감
		if(a!=b) {
			if(a<b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}//end union
	
	private static int find(int a) {
		//a의 부모가 자기자신이라면 루트노드 이므로 리턴 a
		if(parent[a] == a) {
			return a;
		}
		
		//그게 아니라면, 재귀호출로 parent[a]의 부모를 확인
		return parent[a] = find(parent[a]);
	}//end find
	
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return true;
		}
		return false;	
	}//end boolean
	
}







