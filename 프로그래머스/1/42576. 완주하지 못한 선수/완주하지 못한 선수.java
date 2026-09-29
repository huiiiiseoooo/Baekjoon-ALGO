import java.util.HashMap;
import java.util.Iterator;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm1 = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            if(hm1.containsKey(participant[i])){
                int k = hm1.get(participant[i]);
                hm1.put(participant[i], k +1);
            }else{
                hm1.put(participant[i],1);
            }   
        }
        
        for(int i=0; i<completion.length; i++){
            int k = hm1.get(completion[i]);
            hm1.put(completion[i],k-1);
            
        }
        Iterator<String> keys = hm1.keySet().iterator();
        while(keys.hasNext()){
            String key =keys.next();
            if(hm1.get(key) != 0){
                answer += key;
            }
        }
        
        return answer;
    }
}