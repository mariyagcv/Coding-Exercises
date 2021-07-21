package Arrays_Lists;

public class longestUniqueSubstring {

    public static int lengthLongestUniqueSubstrOptimal(String arr) {
        /*
        Complexity: O(N)
        e.g abcabcbb

        in the bruteforce method we would check
        a->ab->abc->abca (stop because we have an overlap)
        slide window
        b->bc->bca->bcab (stop because overlap) ...

        which is O(n^2)

        but we can instead do:
        a->ab->abc->abca (stop because overlap)
        move left pointer by one character:
        bca->bcab-> ...
        idea is that we know that abc before hitting abcA* was unique so we can exclude one by one
        characters from the left (if we have duplicates) and expand characters on the right (when we don't meet a duplicate)

         */
        int maxLength = 0;
        int res = 0;
        int leftPtr, rightPtr;
        leftPtr = rightPtr = 0;

        boolean[] visited = new boolean[256];

        while(rightPtr < arr.length()) {
            if(!visited[arr.charAt(rightPtr)]) {
                visited[arr.charAt(rightPtr)] = true;
                rightPtr++;
                maxLength = Math.max(maxLength, rightPtr-leftPtr);
            }
            else {
                leftPtr++;
                visited[arr.charAt(leftPtr)] = false; // because we slide and exclude it, it's like it hasn't been visited
            }
        }
        return maxLength;
    }
    public static int lengthLongestUniqueSubstr(String arr) {
        /*
        Solution with BRUTEFORCE sliding window technique. Here we don't have an interval K that is given so
        we slide until we meet a repeating character; when we do, we move the window
        (that's why we can't do the optimal version)
        Complexity: O(n^2)
         */

        int maxLength = 0;
        int res = 0;

        for(int i=0; i<arr.length(); i++) {
            // reset the array visited everytime, since we care about the visited for the window range
            boolean[] visited = new boolean[256];

            for(int j=i; j<arr.length(); j++) {
                if(visited[arr.charAt(j)])
                    break;
                else {
                    maxLength = Math.max(maxLength, j-i+1); //j-i+1 because this will give the length of the window
                    visited[arr.charAt(j)] = true;
                }
            }

            //remove (mark) previous occurrence (after we've hit "visited")
            visited[arr.charAt(i)] = false;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "heelloitsme";
        System.out.println("The input string is " + str);

        int len = lengthLongestUniqueSubstrOptimal(str);
        System.out.println("The length is " + len);
    }
}
