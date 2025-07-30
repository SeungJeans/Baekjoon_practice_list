import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[N + 1]; // false가 소수, true가 소수 아님

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        // 에라토스테네스의 체 적용
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}