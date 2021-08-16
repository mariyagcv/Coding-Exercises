package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
        public static void generateParenthesisUtil(int leftPar, int rightPar, ArrayList<String> par, String curr, int max) {
        // base case is when the length is equal to the n input * 2
        if(curr.length() == max*2) {
            par.add(curr);
            return;
        }

        if(leftPar < max) {
            generateParenthesisUtil(leftPar+1, rightPar, par, curr+"(", max);
        }
        if (leftPar > rightPar) {
            generateParenthesisUtil(leftPar, rightPar+1, par, curr+")", max);
        }
    }
    
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generateParenthesisUtil(0, 0, list, "", n);
        
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
