import java.util.PriorityQueue; 
import java.util.Arrays; 

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int s : scoville) {
            heap.add(s);
        }
        
        while(heap.size() >=2 && heap.peek() < K){ //heap 의 자동 정렬 특성을 활용
                int first = heap.poll(); 
                int second = heap.poll(); 
                
                int newNum = first + (second * 2); 
                answer++; 
                
                heap.add(newNum); 
        }
        
        if(heap.peek() < K){
            return -1; 
        }
        return answer;
    }
}
