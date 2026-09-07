class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>(); 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int prevIdx = stack.pop();
                answer[prevIdx] = prices[prevIdx] - prices[i];
            }
            stack.push(i);
        }
        return answer;
    }
}