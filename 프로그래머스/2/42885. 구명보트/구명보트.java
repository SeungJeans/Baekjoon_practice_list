import java.util.Arrays; 

class Solution {
    public int solution(int[] people, int limit) {        
        Arrays.sort(people);
        
        int[] visited = new int[people.length];
        int j = people.length-1;
        int i = 0;              // 가장 가벼운 사람의 인덱스
        int answer = 0;
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++; 
            }
            j--; 
            answer++; 
        }
        return answer;
    }
}