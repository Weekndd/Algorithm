import java.io.*;
import java.util.*;

public class Main {
	static class Person implements Comparable<Person>{
		String name;
		int day, month, year;
		Person(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		public int compareTo(Person o1) {
			if(o1.year==this.year) {
				if(o1.month==this.month) {
					return o1.day-this.day;
				}
				return o1.month-this.month;
			}
			return o1.year-this.year;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	int day = Integer.parseInt(st.nextToken());
        	int month = Integer.parseInt(st.nextToken());
        	int year = Integer.parseInt(st.nextToken());
        	persons[i] = new Person(name, day, month, year);
        }
        Arrays.sort(persons);
        StringBuilder sb = new StringBuilder();
        sb.append(persons[0].name+"\n");
        sb.append(persons[N-1].name);
        System.out.println(sb);
    }
}