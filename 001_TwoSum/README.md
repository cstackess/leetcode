# 001 Two Sum
## Question
[https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
> Given nums = [2, 7, 11, 15], target = 9,
> 
> Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

## Answer
题意是在数组中找到两个数满足相加和为一个目标值。

### 暴力法
首先，容易想到暴力点的解法，复杂度达到$O(n^2)$：
```
TWO-SUM(nums, target){

for i = 1 to nums.length
    for j = i+1 to nums.length
        if nums[i] + nums[j] == target
            return nums[i], nums[j]

}
```
### 哈希表法

很多语言有现成的HashMap可以调用，把数值-索引按照key-value的方式存储进去，这个方法利用map的put/get操作就可以实现，性能好于暴力穷举法，但差于排序查找法。

### 排序查找法
接下来考虑先排好序，再查找。
比如，先进行最优的比较排序（$O(nlgn)$），再循环一遍二分查找（$O(lgn)$）。注意到需要返回原数的索引，因此在排序过程中要么额外保存原数的顺序（难，易错），要么找到值后再来查找原索引，代码如下：

```
TWO-SUM(nums, target){

sorted_nums = SORT(nums, 1, nums.length)
for i = 1 to sorted_nums.length
    j = HALF-FIND(sorted_nums, i+1, sorted_nums.length, target - sorted_nums[i])
    if j > 0
        break
x = -1
y = -1
for p = 1 to nums.length
    if x == -1 and nums[p] == sorted_nums[i] 
        x = p
        continue
    if y == -1 and nums[p] == sorted_nums[j]
        y = p
        continue
return x < y ? nums[x], nums[y] : nums[y], nums[x]

}
```
这样复杂度只有$O(nlgn + nlgn + n) = O(nlgn)$。

在查找这步，也可以在排序后，从头和尾相向查找，可以令$O(nlgn)$的系数减小。

