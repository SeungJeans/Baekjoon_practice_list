import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (a, b)->{
            if(a.charAt(n) == b.charAt(n)){//비교 문자열이 같으면 단어 전체의 사전순으로 비교
                return a.compareTo(b);
            }else{
                return a.charAt(n) - b.charAt(n);
            }
            
        }); 
        
        String[] answer = new String[strings.length]; 
        
        for(int i=0; i<answer.length; i++){
            answer[i] = strings[i]; 
        }
            
        return answer;
    }
}