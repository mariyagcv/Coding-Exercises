package Arrays_Lists;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrRes = new ArrayList<>();


        for(int i : nums1) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int j : nums2) {
                if(map.containsKey(j)) {
                    arrRes.add(j);
                    map.put(j, map.get(j)-1);
                    if (map.get(j) == 0) map.remove(j);

                }

        }
        int resLen = arrRes.size();
        int[] res = new int[resLen];
        for(int i=0; i<resLen;i++) {
            res[i] = arrRes.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println();
    }
}
