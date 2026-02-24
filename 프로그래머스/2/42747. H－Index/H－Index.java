import java.util.Arrays; 

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations); 
        int min = citations[0]; 
        
        if(min > citations.length) return citations.length; 
        
        int h = 0; 
        while(min <= citations.length){
            int time = 0; 
            
            for(int i : citations){
                if(i >= min){
                    time++; 
                }
            }    
            
            if(time >= min) {
                h = min; 
            }else{
                break; 
            }
            
            min++; 
        }
        return h;
    }
}