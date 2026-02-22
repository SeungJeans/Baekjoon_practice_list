public class Solution {
    public int solution(int n) {
        int ans = 0;
        int temp = n; 
        
        while(temp >= 1){
           if(temp % 2 == 0){
               temp/=2; 
           }else{
               temp -= 1; 
               ans++;   
           } 
        }
         
        return ans;
    }
}