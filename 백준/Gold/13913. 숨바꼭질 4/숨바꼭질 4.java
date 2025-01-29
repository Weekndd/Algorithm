import java.util.*;
import java.io.*;

class Main {
	static class Person {
		int l,t;
		Person(int l, int t) {
			this.l = l;
			this.t = t;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Person> que = new LinkedList<>();
        boolean[] visited = new boolean[200001];
        int[] path = new int[200001];
        Arrays.fill(path, -1);
        int ans = 0;
        visited[N] = true;
        que.offer(new Person(N,0));
        while(!que.isEmpty()) {
        	Person person = que.poll();
        	int now = person.l;
        	int time = person.t;
        	if(now == K) {
        		ans = person.t;
        		break;
        	}
        	for(int next : new int[] {now-1, now+1, now*2}) {
        		if (next >= 0 && next < 200001 && !visited[next]) {
        			visited[next] = true;
        			path[next] = now;
        			que.offer(new Person(next, time+1));
        		}
        	}
        } //end while
        StringBuilder sb = new StringBuilder();
        sb.append(ans+"\n");
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=K; i!=-1; i=path[i]) {
        	deque.addFirst(i);
        }
        for(int i : deque) {
        	sb.append(i).append(" ");
        }
        System.out.println(sb);
    }//end main
}