package pekan3_2511531006;

import java.util.Scanner;
import java.util.Stack;

public class StackPostfix_2511531006 {
    public static int postfixEvaluate(String expression) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner input_2511531006 = new Scanner(expression);
        
        while (input_2511531006.hasNext()) {
            if (input_2511531006.hasNextInt()) {
                s.push(input_2511531006.nextInt());
            } else {
                String operator = input_2511531006.next();
                int operand2_2511531006 = s.pop();
                int operand1_2511531006 = s.pop();
                if (operator.equals("+")) {
                    s.push(operand1_2511531006 + operand2_2511531006);
                } else if (operator.equals("-")) {
                    s.push(operand1_2511531006 - operand2_2511531006);
                } else if (operator.equals("*")) {
                    s.push(operand1_2511531006 * operand2_2511531006);
                } else {
                    s.push(operand1_2511531006 / operand2_2511531006);
                }
            }
        }
        input_2511531006.close();
        return s.pop();
    }
    
    public static void main(String[] args) {
        System.out.println("Hasil postfix= " + postfixEvaluate("5 2 4 * 7 -"));
    }
}
