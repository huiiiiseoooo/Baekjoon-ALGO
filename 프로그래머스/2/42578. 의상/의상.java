import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i< clothes.length; i++){
            if(hm.containsKey(clothes[i][1])){
                int k = hm.get(clothes[i][1]);
                hm.put(clothes[i][1], k+1);
            }else{
                hm.put(clothes[i][1], 1);
            }
        }
        
        int k=1;
        
        for(String key: hm.keySet()){
            k = k * (hm.get(key)+1);
        }
        answer = k-1;
        
        return answer;
    }
}