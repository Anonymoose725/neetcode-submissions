class MinStack {
    // two stack solution:
        // stack stores all pushed values
        // minStack stores the minimum so far, at each level of stack
        // this ensures that the top of minStack is always the minimum of the whole stack, so getMin() works in O(1)

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

    public MinStack() { // constructor
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val); // polymorphism
        // check to maintain min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val); // new min
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = minStack.peek();
        int maybeMin = stack.peek();
        if (maybeMin < min) {
            minStack.push(maybeMin);
            return maybeMin;
        }
        else return min;
    }
}
