# 004 Median of Two Sorted Arrays
## Question
[https://leetcode.com/problems/median-of-two-sorted-arrays/](https://leetcode.com/problems/median-of-two-sorted-arrays/)

There are two sorted arrays **nums1** and **nums2** of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

## Answer

题意是从两个分别已排序数组找到它们的中位数，时间复杂度O(log (m+n))。

### 双指针法
类似归并排序的合并步骤，两个指针分别扫描两个已排序数组，并按序合并到新的数组nums：

* 如果m+n为偶数，中位数就为 (nums[(m+n)/2]+nums[(m+n)/2+1]) / 2
* 如果m+n为奇数，中位数就为 nums[(m+n+1)/2]

由于flour((m+n+1)/2)=(m+n)/2，ceil((m+n+1)/2)=(m+n)/2+1，所以都可以视为( nums[flour((m+n+1)/2)] + nums[ceil((m+n+1)/2)] ) / 2。

也就是要扫描一半的m+n，时间复杂度为O(m+n)。


### 二分法

二分查找一个长度为n的已排序数组的时间复杂度为O(log n)，可以给予一些启发。

中位数的含义是50%的数小于它，50%的数大于它。假设分别从nums1和nums2取得前p%（数x_p分割）和前q%（数x_q分割），如果p+q=50且x_p=x_q，则x_p(x_q）就是它们的中位数。

因此把二分查找方法应用进去，伪代码如下：

```
FIND-MEDIAN-SORTED-ARRAYS(nums1, nums2){

m0 = 1
n0 = 1
m = nums1.length
n = nums2.length
x = FIND-MEDIAN(nums1, m0, m)
y = FIND-MEDIAN(nums2, n0, n)
while x != y
    if x > y
        m = (m0 + m) / 2
        x = FIND-MEDIAN(nums1, m0, m)
        n0 = (n0 + n) / 2
        y = FIND-MEDIAN(nums2, n0, n)
    else 
        m0 = (m0 + m) / 2
        x = FIND-MEDIAN(nums1, m0, m)
        n = (n0 + n) / 2
        y = FIND-MEDIAN(nums2, n0, n)

return x

}


FIND-MEDIAN(nums, p, q){
value = (p + q + 1) / 2
return ( nums[flour(value)] + nums[ceil(value)] ) / 2
}
```

