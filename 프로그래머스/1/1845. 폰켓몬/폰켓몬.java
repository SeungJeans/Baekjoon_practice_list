import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
        int answer = 0;
        int max = (nums.length) / 2; 
        
        for(int i=0; i<nums.length; i++){
          map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   
        }
        
        for (Integer key : map.keySet()){
            if(max <=0) break; 
            max--; 
            answer++; 
        }
        
        return answer;
    }
        
}