class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0; 
        
        for(int i=1; i<=count; i++){
            sum += i; 
        }
        
        long cost = price * sum; 
        
        if(cost > money){
            answer = cost - money;
            return answer; 
        }else{
            return 0;         
        }
    }
}