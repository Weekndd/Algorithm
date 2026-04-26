import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int G = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String W = br.readLine();
		String S = br.readLine();
		int[] wArr = new int[52];
		int[] sArr = new int[52];
		for(char c : W.toCharArray()) {
			putWord(c, wArr, 1);
		}
		
		int ans = 0;
		for(int i=0; i<S.length(); i++) {
			if(i-W.length()<0) { //0-g까지는 계속 추가
				putWord(S.charAt(i), sArr, 1);
				continue;
			}
			if(Arrays.equals(wArr, sArr)) ans++;
			putWord(S.charAt(i-W.length()), sArr, -1);
			putWord(S.charAt(i), sArr, 1);
		}
		if(Arrays.equals(wArr, sArr)) ans++;
		System.out.println(ans);
	}//end main
	static void putWord(char word, int[] arr, int dif) {
		if('a'<=word && word<='z') {
			arr[word-'a']+=dif;
		}
		else {
			arr[word-'A'+26]+=dif;
		}
	}
}
