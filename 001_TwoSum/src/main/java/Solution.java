/**
 * Created by Administrator on 2016/2/2.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int one_index = 0;
        int two_index = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == (target - numbers[i])) {
                    one_index = i;
                    two_index = j;
                    break;
                }
            }
        }
        return new int[]{one_index + 1, two_index + 1};
    }

/*Wrong: Map数据结构，不能处理两值相等，如2+2=4的情况*/
/*  public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        Set<Integer> keys = map.keySet();
        int[] result = new int[2];
        for (Iterator<Integer> iterator1 = keys.iterator(); iterator1.hasNext(); ) {
            Integer one = iterator1.next();
            Integer two = target - one;
            Integer one_index = map.get(one);
            Integer two_index = map.get(two);
            if (two_index != null) {
                if (one_index < two_index) {
                    result[0] = one_index;
                    result[1] = two_index;
                } else {
                    result[0] = two_index;
                    result[1] = one_index;
                }
            }
        }
        return result;
    }*/


/*Wrong: Arrays.binarySearch要求必须先进行Arrays.sort(..)，否则查询不正确*/
/*    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int[] newNumbers = Arrays.copyOfRange(numbers, i + 1, numbers.length);
            int two_index = Arrays.binarySearch(newNumbers, target - numbers[i]);
            if (-1 != two_index) {
                return new int[]{i + 1, two_index + i + 1};
            }
        }
        return new int[]{0, 0};
    }*/
}
