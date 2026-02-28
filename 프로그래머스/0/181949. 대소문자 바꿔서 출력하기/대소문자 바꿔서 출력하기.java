import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder answer = new StringBuilder(); 
        
        for(int i=0; i<a.length(); i++){
            char ch = a.charAt(i); 
            if(Character.isUpperCase(ch)){
                answer.append(Character.toLowerCase(ch));        
            }else{
                answer.append(Character.toUpperCase(ch)); 
            }
        }
        
        System.out.println(answer);  
    }
}