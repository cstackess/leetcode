import java.util.*;

import static java.util.Arrays.*;

/**
 * Created by Administrator on 2016/2/2.
 */
public class Solution {



    /*排序查询法，O(nlgn)，5ms*/
    public int[] twoSum(int[] numbers, int target) {
        int[] copyNumbers = copyOf(numbers, numbers.length);
        sort(numbers);
        int i, j = 0;
        for (i = 0; i < numbers.length; i++) {
            j = binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j > 0) {
                break;
            }
        }
        System.out.println(i + "," + j);
        int x = -1, y = -1;
        for (int t = 0; t < copyNumbers.length; t++) {
            if (x == -1 && copyNumbers[t] == numbers[i]) {
                x = t;
                continue;
            }
            if (y == -1 && copyNumbers[t] == numbers[j]) {
                y = t;
                continue;
            }
        }
        return x < y ? new int[]{x, y} : new int[]{y, x};
    }

    /*暴力法，O(n^2)，52ms*/
    /*public int[] twoSum(int[] numbers, int target) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == (target - numbers[i])) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        return new int[]{x, y};
    }*/

    /*哈希表法，12ms*/
    /*public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            Vector<Integer> v = map.get(numbers[i]);
            if (v != null)
                v.add(i);
            else {
                Vector<Integer> newV = new Vector<Integer>();
                newV.add(i);
                map.put(numbers[i], newV);
            }
        }
        int x = -1, y = -1;
        Set<Integer> keys = map.keySet();
        for (Iterator<Integer> iterator1 = keys.iterator(); iterator1.hasNext(); ) {
            Integer one = iterator1.next();
            Integer two = target - one;
            x = map.get(one).get(0);
            Vector<Integer> v = map.get(two);
            if (v != null) {
                y = v.get(v.size() - 1);
                break;
            }
        }
        return x < y ? new int[]{x, y} : new int[]{y, x};
    }*/
}
