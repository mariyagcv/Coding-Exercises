package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class LetterCombinationsOfPhone {
    /*
    Complexity: O(N*4^N) where N is the length of digits ("234");
    we have 4 because each digit maps to at most 4 letters; so we have 4^N depth of the recursive tree
    and we have N* 4^N for each operation we do at each level
     */
    public static HashMap createMapping() {
        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        recurse(0, res, digits, "", createMapping());
        return res;
    }

    public static void recurse(Integer digitIndex, ArrayList<String> result, String digits, String current, HashMap<Character, String> map) {
        // base case: if the digit is equal to the length of the full number, we've processed all
        if(digitIndex == digits.length()) {
            result.add(current);
            return;
        }
        // e.g if we have "234" this will do map.get(digits[0]) = 2->abc, map.get(digits[1]) = 3->def...
        // when this index reaches the length of the digits array, it means that we have finished converting
        // all of the digits to letters

        String lettersOfCurrentDigit = map.get(digits.charAt(digitIndex));

        for(int i=0; i<lettersOfCurrentDigit.length(); i++) { // now we will iterate over each char (a, b, c)...
            // i.e we add to what we had the current character and we increase the index
            recurse(digitIndex+1, result, digits, current+lettersOfCurrentDigit.charAt(i), map);
        }
    }
//    ---------------- Same solution but with stack
    // todo: this has bugs, fix it ...
    public static ArrayList<String> stackSolution(String digits, HashMap<Character, String> map) {
        Stack<String> st = new Stack<>();
        st.push("");
        int digitIndex = 0;
        ArrayList<String> res = new ArrayList<>();
        while(st.peek().length() != digits.length()) {
            String current = st.peek();
            res.add(current);
            st.pop();

            String lettersOfNumber = map.get(digits.charAt(digitIndex));

            for(char c : lettersOfNumber.toCharArray()) {
                st.push(current+c);
            }
            digitIndex++;

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(stackSolution("234", createMapping()));

    }
}
