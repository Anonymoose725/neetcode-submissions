class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // DP or stack
        // go from right to left
        // stack contains days waiting for a warmer temperature
        int [] results = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // [temperature, index]

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] day = stack.pop();
                results[day[1]] = i - day[1];
            }
            stack.push(new int[]{temp, i});
        }

        return results;
    }
}
