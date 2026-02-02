import java.util.List; 
import java.util.ArrayList; 
import java.util.HashMap;  

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++){ //초기화 시키기
            answer[i] = 0; 
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>(); //횟수 정리 
        
        for(String r : report){ //report 내용 정리하는 부분 
            String[] temp = r.split(" ");
            String accuser = temp[0]; // 신고자
            String accused = temp[1]; // 피신고자
            
            if (!map.containsKey(accuser)) {
                map.put(accuser, new ArrayList<>());
            }
            
            List<String> list = map.get(accuser);
            if (!list.contains(accused)) { //list에 없는 경우만 추가하기
                list.add(accused);
                count.put(accused, count.getOrDefault(accused, 0) + 1); 
            }
        }
        
        ArrayList<String> stop = new ArrayList<>(); 
        for(String name : id_list){
            if(count.getOrDefault(name, 0) >= k){
                stop.add(name); 
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> result = map.get(user);
            
            if(result != null) {
                for(String name : result) {
                    if(stop.contains(name)) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}