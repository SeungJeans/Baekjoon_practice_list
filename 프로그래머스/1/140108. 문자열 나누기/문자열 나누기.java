class Solution {
    public int solution(String s) {
        int answer = 0;
        String sen = s; 
        
        while(!sen.equals("")){
            char first = sen.charAt(0); 
            int isX = 0; 
            int isNX = 0; 
            
            for(int i=0; i<sen.length(); i++){
                if(isX !=0 && isNX != 0 && isX == isNX){
                    break; 
                }
                
                char ch = sen.charAt(i); 
                
                if(ch == first) isX++; 
                else isNX++; 
            }
            
            int start = isX + isNX; 
            sen = sen.substring(start, sen.length()); 
            answer++;            
        }
        
        return answer;
    }
}