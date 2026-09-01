class Solution {
    public int evalRPN(String[] tokens) {
        // operators apply to the two most recent operands
        Stack<Integer> operands = new Stack<>();
        // start is always an operand

        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                // is operand, push to stack
                operands.push(Integer.parseInt(tokens[i]));
            }
            else {
                int result;
                int op2 = operands.pop();
                int op1 = operands.pop();
                switch(tokens[i]) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        if (op2 == 0) throw new ArithmeticException("Divide by 0");
                        else {
                            result = op1 / op2;
                        }
                        break;
                    default:
                        throw new ArithmeticException("Invalid operator");
                }
                operands.push(result);
            }
        }
        return operands.pop();
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
