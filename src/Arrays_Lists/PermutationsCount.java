package Arrays_Lists;

public class PermutationsCount {
    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println("prefix: " + prefix);
        }
        else {
            for (int i=0; i<str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i+1);
                System.out.println("rem is: " + rem);
                System.out.println("prefix is: " + prefix);
                System.out.println("charAtI is: " + str.charAt(i));
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    // ------------------------- permutation with swapping...
    public char[] swap(char[] arr, int a, int b) {
        char tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

        return arr;
    }

    public void permuteWithSwapRecursion(char[] arr, int left, int right) {
        // base case ....
        if(left==right)
            System.out.println(arr);

        for(int i = left; i<=right; i++) {
            arr = swap(arr, left, i);
            permuteWithSwapRecursion(arr, left+1, right); // left + 1 means we fix one more element
            arr = swap(arr, left, i); // we swap it back because when we backtrack we want to have the original non-swapped arr
        }
    }

    public void permuteWithSwap(String str) {
        permuteWithSwapRecursion(str.toCharArray(), 0, str.length()-1);
    }

    public static void main(String[] args) {
        PermutationsCount permutation = new PermutationsCount();
        permutation.permuteWithSwap("abc");
    }


}

