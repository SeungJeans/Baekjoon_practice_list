import java.util.Arrays; 

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] nums = Arrays.stream(s.split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray(); 
        
        int minNum = nums[0];
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minNum = Math.min(minNum, nums[i]); 
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        answer += (minNum) + " " + (maxNum); 
        return answer;
    }
}