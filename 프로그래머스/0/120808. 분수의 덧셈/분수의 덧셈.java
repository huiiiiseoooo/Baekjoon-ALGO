class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0,0};
        answer[0] = numer1 * denom2 + numer2 * denom1;
        answer[1] = denom1 * denom2;
        int temp = gcd(answer[0], answer[1]);
        
        answer[0] = answer[0]/temp;
        answer[1] = answer[1]/temp;
        
        return answer;
    }
    public int gcd(int a, int b){
        int temp = a;
        if(a%b == 0){
            return b;
        }else{
            a = b;
            b = temp%b;
            
            return gcd(a,b); 
        }
       
    }
}