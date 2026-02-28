import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int count = num_list.length - n + 1;
        int[] answer = new int[count]; 
        
        int index = 0; 
        for(int i=n-1; i<num_list.length; i++){
            answer[index++] = num_list[i]; 
        }
        
        return answer;
    }
}