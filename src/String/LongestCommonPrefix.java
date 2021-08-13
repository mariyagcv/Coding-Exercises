package String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //bruteforce solution

        StringBuilder str = new StringBuilder();
        int minLengthStr = strs[0].length();
        char[] res = new char[minLengthStr];

        for(int i=0; i<strs.length; i++) {
            if(strs[i].length()<minLengthStr)
                minLengthStr=strs[i].length();
        }

        int resIndex=0;
        boolean sameChar = false;
        for(int i=0; i<minLengthStr; i++) {
            char first = strs[0].charAt(i); // f; l; o; w (e,r won't be checked because we loop 4 times, minlengthStr length)
            for(int j=0; j<strs.length; j++) {
                if(strs[j].charAt(i)!=first) {
                    return str.toString();
                }
            }
            str.append(first);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String res = longestCommonPrefix(new String[]{"flower","flow","flight"}); //try {"car", "cir"}
        System.out.println(res);
    }
}
