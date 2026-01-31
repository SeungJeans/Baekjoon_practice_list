import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1); 
        }
        
        //int[] arr = map.values(); 
        List<Integer> list = new ArrayList<>(map.values()); 
        list.sort(Collections.reverseOrder());//값을 큰 것부터 정렬하도록 함 
        
        int answer = 0;
        int quantity = 0;
        int index = 0; 
        
        while (quantity < k){
            quantity += list.get(index++);
            answer++; 
        }
        return answer;
    }
}