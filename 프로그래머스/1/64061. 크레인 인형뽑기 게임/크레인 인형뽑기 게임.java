import java.util.Stack; 

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>(); //크기가 충분히 큰 바구니를 스택으로 표현
        
        for(int i=0; i<moves.length; i++){ //배열은 length 사용 
            int col = moves[i] - 1; 
            int doll = 0;
            
            for(int row = 0; row < board.length; row++){
                if(board[row][col] == 0){
                    continue;
                }else{
                    doll = board[row][col];
                    board[row][col] = 0; // 뽑은 자리는 0으로 수정
                    break; 
                }
            }
            
            if (doll == 0) continue; 
            
            if(!basket.isEmpty() && basket.peek() == doll){
                basket.pop(); 
                answer += 2;
            }
            
            else{
                    basket.push(doll); 
                } 
        }
        return answer;
    }
}