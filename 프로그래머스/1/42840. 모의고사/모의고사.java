import java.util.Arrays; 
import java.util.HashMap; 
import java.util.Collections; 
import java.util.ArrayList; 

class Solution {
    public int[] solution(int[] answers) {
        
        HashMap<Integer, Integer> people = new HashMap<>(); 
        
        for(int i=0; i<3; i++){
            people.put(i+1, 0);
        }
        
        String[] pattern = {"12345", "21232425", "3311224455"}; 
        
        for(int count=0; count<3; count++){
            char[] temp = pattern[count].toCharArray(); 
            int index = 0; 
            
            for(int i=0; i<answers.length; i++){
                if(index >= temp.length) index %= temp.length; 
                
                if(answers[i] == Character.getNumericValue(temp[index])){
                    people.put(count+1, people.getOrDefault(count+1, 0)+ 1); 
                }
                index++; 
            }
        }
        
        int[] result = new int[3]; 
        for(int i=0; i<result.length; i++){
            result[i] = people.get(i+1); 
        }
        
        int maxScore = Math.max(result[0], Math.max(result[1], result[2]));
        
        ArrayList<Integer> list = new ArrayList<>();

        if (result[0] == maxScore) list.add(1); // 1번 수포자가 최고점과 같다면 추가
        if (result[1] == maxScore) list.add(2); // 2번 수포자가 최고점과 같다면 추가
        if (result[2] == maxScore) list.add(3); // 3번 수포자가 최고점과 같다면 추가
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i); 
        }
        
        Arrays.sort(answer);         
        return answer;
    }
}