import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int left, right, num, idx;
		Node(int num, int idx) {
			this.num = num;
			this.idx = idx;
			this.left = -1;
			this.right= -1;
		}
	}
	static int size = 0;
	static List<Node> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		int root = Integer.parseInt(br.readLine());
		list.add(new Node(root, size++));
		while(true) {
			String str = br.readLine();
			if(str==null || str.equals("")) break;
			int num = Integer.parseInt(str);
			makeTree(0,num);
			list.add(new Node(num,size++));
		} //end input
		dfs(0);
		System.out.println(sb);
	}//end main
	
	static void makeTree(int idx, int num) {
		Node now = list.get(idx);
		if(now.num<num) {
			if(now.right==-1) now.right = size;
			else makeTree(now.right,num);
		}
		else {
			if(now.left==-1) now.left = size;
			else makeTree(now.left, num);
		}
	}//end makeTree
	
	static void dfs(int idx) {
		Node now = list.get(idx);
		//왼쪽 방문
		if(now.left!=-1) {
			dfs(now.left);
		}
		//오른쪽 방문
		if(now.right!=-1) {
			dfs(now.right);
		}		
		sb.append(now.num+"\n");
	}
}
