import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<Integer>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) { //수열을 arr에 저장하여 표현
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = 1, count = 0;
        int result = 0;

        while (count < n) {
            if (i <= n) {
                s.push(i);
                sb.append('+').append('\n');
                i++;

                while (!s.empty() && s.peek() == arr[count]) {
                     s.pop();
                     sb.append('-').append('\n');
                     count++;
                }
            }

            else{
                if(!s.empty() && s.pop() == arr[count]){
                    sb.append('-').append('\n');
                    count++;
                }
                else{
                    result = 1;
                    break;
                }
            }
        }

        if(result==1){
            System.out.println("NO");
        }
        else{
            System.out.println(sb);
        }
        br.close();
    }
}