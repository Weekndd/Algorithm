import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		List<String> tempList = new ArrayList<>(set);
		Collections.sort(tempList);
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<51; i++) {
			for(int j=0; j<tempList.size(); j++) {
				if(tempList.get(j).length() == i) {
					list.add(tempList.get(j));
				}
			}
		}
		for(String s : list){
            System.out.println(s);
        }
		
	}
}