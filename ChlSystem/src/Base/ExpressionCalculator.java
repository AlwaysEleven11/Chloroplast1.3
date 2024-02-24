package Base;

import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionCalculator {
        public static boolean isEquation(String input) {
            // 去除空格
            input = input.replace(" ", "");

            // 检查是否只包含合法字符，不是则不通过
            if (!Pattern.matches("[0-9()+\\-*/]+", input)) {
                return false;
            }

            // 检查括号是否匹配，不匹配则不通过
            if (!checkParentheses(input)) {
                return false;
            }

            // 检查运算符的位置，不合法则不通过
            if (!checkOperatorPositions(input)){
                return false;
            }
            //检查是否为单个数字，是则不通过
            if(isNumber(input)){
                return false;
            }

            return true;
        }
        public static boolean isNumber(String input) {
           return Pattern.matches("-?\\d+(\\.\\d+)?", input);
        }
        private static boolean checkParentheses(String input) {
            int count = 0;  // 用于记录左右括号的匹配数量
            for (char c : input.toCharArray()) {
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                    // 右括号出现在左括号之前，或右括号数量超过左括号，均为不合法
                    if (count < 0) {
                        return false;
                    }
                }
            }
            return count == 0;  // 左右括号匹配数量相等才算合法
        }

        private static boolean checkOperatorPositions(String input) {
            // 算式不能以运算符开头或结尾
            if (isOperator(input.charAt(0)) || isOperator(input.charAt(input.length() - 1))) {
                return false;
            }

            // 两个运算符不能连续出现
            for (int i = 0; i < input.length() - 1; i++) {
                char current = input.charAt(i);
                char next = input.charAt(i + 1);
                if (isOperator(current) && isOperator(next)) {
                    return false;
                }
            }

            return true;
        }


    public static double evaluateExpression(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                numBuilder.append(c);

                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    numBuilder.append(expression.charAt(i + 1));
                    i++;
                }

                double operand = Double.parseDouble(numBuilder.toString());
                operands.push(operand);
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    performOperation(operands, operators);
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(operands, operators);
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        return operands.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    private static void performOperation(Stack<Double> operands, Stack<Character> operators) {
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        char operator = operators.pop();

        double result;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        operands.push(result);
    }

    public static void main(String[] args) {
     System.out.println(
        isEquation("2 + 4")+"\n"+
        isEquation("2 + 4 +")+"\n"+
        isEquation("2 + ")+"\n"+
        isEquation("2")+"\n"+
        isEquation("2 ++ 4")
     );
    }
}