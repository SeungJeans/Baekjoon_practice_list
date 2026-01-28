import java.util.HashMap; 
import java.util.ArrayList; 

class Solution {
    public String[] solution(String[] record) {
        // String[] answer = {};
        // return answer;
        ArrayList<String> result = new ArrayList<>(); 
        HashMap<String, String> user = new HashMap<>(); 
        
        for(String r : record){
            String[] message = r.split(" ");
            
            String userId = message[1];
            
            if(message.length>2){
                String userNick = message[2]; 
                user.put(userId, userNick); 
            }
        }
        
        for(String r : record){
            String[] message = r.split(" "); 
            
            String order = message[0]; 
            String userId = message[1];
            
            switch(order){
                case "Enter": 
                    result.add(user.get(userId) + "님이 들어왔습니다.");
                    break;
                case "Change":
                    break; 
                case "Leave": 
                    result.add(user.get(userId) + "님이 나갔습니다."); 
            }    
        }
        
        return result.stream().toArray(String[]::new); 
    }
}