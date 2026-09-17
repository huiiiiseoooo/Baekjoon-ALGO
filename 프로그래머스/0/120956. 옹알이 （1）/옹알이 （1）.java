class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {

            // 같은 발음이 연속으로 나오는 경우
            if (str.matches(".*(ayaaya|yeye|woowoo|mama).*")) {
                continue;
            }

            // 전체가 옹알이 발음으로만 이루어져 있는지 확인
            if (str.matches("(aya|ye|woo|ma)+")) {
                answer++;
            }
        }

        return answer;
    }
}