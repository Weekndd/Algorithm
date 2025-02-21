import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String MBTI = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : MBTI.toCharArray()) {
            switch (c) {
                case 'E': sb.append('I'); break;
                case 'I': sb.append('E'); break;
                case 'S': sb.append('N'); break;
                case 'N': sb.append('S'); break;
                case 'T': sb.append('F'); break;
                case 'F': sb.append('T'); break;
                case 'J': sb.append('P'); break;
                case 'P': sb.append('J'); break;
            }
        }

        System.out.println(sb);
    }
}