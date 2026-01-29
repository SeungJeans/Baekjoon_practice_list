import java.util.HashMap; 

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> client = new HashMap<>(); 
        
        for(int i=0; i<want.length; i++){ //고객이 원하는 상품에 대해 제품명과 개수를 해시맵으로 저장
            String product = want[i]; 
            int amount = number[i]; 
            
            client.put(product, amount); 
        }
        
        for(int i=0; i<=(discount.length-10); i++){
            HashMap<String, Integer> mart = new HashMap<>();
            int max = i+9;
            int start = i; 
            
           for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                mart.put(product, mart.getOrDefault(product, 0) + 1);
            }
            
            //고객의 key 값을 빼오고, 그에 대한 value 와 mart value의 값을 비교해야 함. 
            boolean pass = true;
            for (String clientP : client.keySet()){
                if(mart.containsKey(clientP)){
                    if(client.get(clientP) > mart.get(clientP)){
                        pass = false; 
                        break;
                    }
                }else{
                    pass = false; 
                    break;
                }
            }
            
            if (pass) { // 10개 품목 조건이 모두 맞을 때만 하루 카운트
                answer++;
            }
        }
        return answer;
    }
}