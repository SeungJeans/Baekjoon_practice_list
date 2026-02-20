import java.util.Arrays; 

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // int[] 배열은 이렇게만 써도 기본 오름차순으로 정렬됩니다.
        Arrays.sort(d); 
        
        for(int i=0; i<d.length; i++){
            if(budget >= d[i]){
                budget -= d[i]; 
                answer++; 
            }
        }
        return answer;
    }
}