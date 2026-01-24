import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] num = new int[progresses.length]; 
        
        for(int i=0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            int days = (remain + speeds[i] - 1) / speeds[i];
            num[i] = days; 
        }
        
        Stack<Integer> stack = new Stack<>(); 
        int[] tempAnswer = new int[progresses.length];
        int max = 0;
        int index = 0; 
        
        for(int i=0; i<num.length; i++){
            if(stack.isEmpty()){
                stack.push(num[i]); 
                max = num[i]; 
            }else{
                if(max >= num[i]){
                    stack.push(num[i]); 
                }
                else{
                    int count = 0;
                    while (!stack.isEmpty()) { // 스택이 빌 때까지 반복 추출
                        stack.pop();
                        count++; 
                    }
                    
                    tempAnswer[index++] = count; 
                    stack.push(num[i]);
                    max = num[i];
                }
            }
        } 
        
        if (!stack.isEmpty()) {
            int count = 0;
            while (!stack.isEmpty()) {
                stack.pop();
                count++;
            }
            tempAnswer[index++] = count;
        }
        
        int[] answer = new int[index];
        
        for(int j=0; j<index; j++) {
            answer[j] = tempAnswer[j];
        }
    return answer;
    }
}