package Stacks_Queues;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int res;

        for (String c : tokens) {
            if (c != "*" && c != "/" && c != "-" && c != "+") {
                st.push(c);
            } else { // special char
                int rightNumber = Integer.parseInt(st.pop());
                int leftNumber = Integer.parseInt(st.pop());

                String choice = c;

                switch (choice) {
                    case "+":
                        res = leftNumber + rightNumber;
                        st.push("" + res);
                        break;
                    case "*":
                        res = leftNumber * rightNumber;
                        st.push("" + res);
                        break;
                    case "/":
                        res = leftNumber / rightNumber;
                        st.push("" + res);
                        break;
                    default:
                        continue;

                }
            }
        }

        return Integer.parseInt(st.pop()); //not returning the "res" since "res" is just the last temporary result

    }
}
