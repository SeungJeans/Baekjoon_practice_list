import java.util.*;
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<TC; i++){
            sb.append(parenthesis(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String parenthesis(String problem){
        Stack<Character> s = new Stack<Character>();

        for(int i=0; i<problem.length(); i++){

            char c = problem.charAt(i);

            if(c == '('){
                s.push(c);
            }
            else{
                if(s.empty()){
                    return "NO";
                }
                else{
                    s.pop();
                }
            }
        }

        if(s.empty()){
           return "YES";
        }
        else{
            return "NO";
        }
    }
}
