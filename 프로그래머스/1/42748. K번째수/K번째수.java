import java.util.Arrays;  

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int c=0; c<commands.length; c++){ //주어진 테스트 케이스만큼 반복
            int i = commands[c][0]; 
            int j = commands[c][1];
            int k = commands[c][2]; 
            
            int[] temp = new int[j - i + 1];
            int start = i - 1; 
            int index = 0;    // temp용 인덱스
            
            while(index < temp.length) {
                temp[index] = array[start];
                start++;
                index++;
            } 
            
            Arrays.sort(temp); //temp 를 오름차순 정렬 
            
            answer[c] = temp[k-1]; 
        }
        return answer;
    }
}