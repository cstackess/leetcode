/**
 * Created by Administrator on 2016/2/4.
 */
public class Solution {
    //已排序的数组，复杂度O(m+n)，如何达到O(log(m+n))？
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //X_1,X_2,...,X_N的中位数
        //N为奇数，中位数为X_(N+1)/2
        //N为偶数，中位数为(X_N/2 + X_(N/2+1)) / 2
        //可统一为 (flour(X_(N+1)/2) + ceil(X_(N+1)/2)) / 2
        int target_1 = (m + n + 1) / 2;
        int target_2 = (int) Math.ceil((m + n + 1) / 2.0);
        int[] mergedNums = new int[target_2];
        int p = 0;
        int q = 0;
        for (int count = 0; count < target_2; count++) {
            if (p >= m) {
                mergedNums[count] = nums2[q++];
                continue;//该跳掉
            }
            if (q >= n) {
                mergedNums[count] = nums1[p++];
                continue;
            }
            if (p < m && q < n) {
                if (nums1[p] <= nums2[q]) {
                    mergedNums[count] = nums1[p++];
                } else {
                    mergedNums[count] = nums2[q++];
                }
            }
        }
        return (mergedNums[target_1 - 1] + mergedNums[target_2 - 1]) / 2.0;
    }
}
