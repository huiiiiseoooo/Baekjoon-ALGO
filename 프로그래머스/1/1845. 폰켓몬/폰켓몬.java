import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            
            if(hm.containsKey(nums[i])){
                int k =hm.get(nums[i]);
                hm.put(nums[i], k+1);
            }else{
                hm.put(nums[i], 1);
                answer++;
            }
            if(answer >= nums.length/2){
                answer = nums.length/2;
            }else{
                answer = hm.size();
            }
            
        }
        return answer;
    }
}