class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(); 
        
        s = s.toLowerCase(); 
        //한 자씩 순회하면서 공백을 만나면 
        //또 공백인지 검사하고 
        //아니면 바로 다음 것은 대문자로 변환하도록 해야 할 것 같음. 
        if(!Character.isDigit(s.charAt(0))){
            char first = s.charAt(0); 
            char upper = Character.toUpperCase(first); 
            sb.append(upper); 
        }else{
            sb.append(s.charAt(0)); 
        }  
        
        boolean isFirst = false;    
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i); 
            
            if(ch == ' '){ //공백이면
                sb.append(ch);
                isFirst = true; 
            }
            else{
               if(isFirst){//단어의 첫 글자가 맞는지 확인
                    isFirst = false;
                    char upper = Character.toUpperCase(ch);
                    sb.append(upper);   
                }
                else{
                   sb.append(ch); 
                }
            }
       }
    
        return sb.toString();
    }
}