import java.util.*;
import java.io.*;

public class Main {
	public static class User {
		int level;
		String name;
		boolean isJoin;
		public User(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}
	static int P, M;
	static ArrayList<User> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        for(int i=0; i<P; i++) {
        	st = new StringTokenizer(br.readLine());
        	int level = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	
        	list.add(new User(level, name));
        }
        for(int i=0; i<list.size(); i++) {
        	User user = list.get(i);
        	if(user.isJoin) continue;
        	findRoom(i,user);
        }
        System.out.println(sb);
	}//end main
	
	public static void findRoom(int idx, User user) {
		List<User> res = new ArrayList<>();
		res.add(user);
		for(int i=0; i<P; i++) {
			if(res.size()==M) break;
			if(idx==i) continue;
			User other = list.get(i);
			if(other.isJoin || Math.abs(other.level-user.level)>10) continue;
			res.add(other);
		}
		startGame(res);
	}
	
	public static void startGame(List<User> res) {
		Collections.sort(res, (o1,o2) -> o1.name.compareTo(o2.name));
		if(res.size()==M) {
			sb.append("Started!\n");
			for(User user : res) {
				user.isJoin = true;
				sb.append(user.level+" "+user.name+"\n");
			}
		}
		else {
			sb.append("Waiting!\n");
			for(User user : res) {
				user.isJoin = true;
				sb.append(user.level+" "+user.name+"\n");
			}
		}
		
	}
}
