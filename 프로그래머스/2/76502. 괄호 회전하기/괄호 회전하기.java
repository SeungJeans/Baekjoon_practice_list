import java.util.Stack; 

class Solution {
    public int solution(String s) {
        int answer = 0; 
         
        for(int i=0; i<s.length(); i++){
            if(check(s, i)){
                answer++; 
            }   
        }
        return answer;
    }
    
    boolean check(String s, int x){
        Stack<Character> stack = new Stack<>();
        int l = s.length(); 
        
        for(int i=0; i<l; i++){ //s문자열 전체 순회
            char ch = s.charAt((i + x) % l);
            
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch); 
            }
            else{
                if(stack.isEmpty()){
                    return false; 
                }else{
                    char top = stack.pop();
                    if (ch == ')' && top != '(') return false;
                    if (ch == ']' && top != '[') return false;
                    if (ch == '}' && top != '{') return false;
                }
            }
        }
        
        return stack.isEmpty();
    } 
}