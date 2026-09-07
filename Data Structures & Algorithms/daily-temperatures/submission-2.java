class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // DP or stack
        // go from right to left
        // stack contains days waiting for a warmer temperature
        int [] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // stores indexes of days waiting for decided result

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int index = stack.pop();
                results[index] = i - index;
            }
            stack.push(i);
        }

        return results;
    }
}
