class Solution {
    public boolean isValid(String s) {
        // two stacks - last in, first out
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // push open brackets to stack
            // if bracket is closing, check for opener on stack
            // if not right match on stack, return false
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            }
            else {
                if (stack.isEmpty()) return false;
                switch (bracket) {
                    case ']':
                        if (stack.pop() != '[') return false;
                        else break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        else break;
                    case ')': 
                        if (stack.pop() != '(') return false;
                        else break;
                }        
            }
        }
        return stack.isEmpty();
    }
}
