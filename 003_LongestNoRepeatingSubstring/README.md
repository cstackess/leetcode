# 003 Longest Substring Without Repeating Characters
## Question
[https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string, find the length of the longest substring without repeating characters. 

> For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
> For "bbbbb" the longest substring is "b", with the length of 1.

## Answer

题意是求不重复子字符串的最大长度。

用L(i,j-1)表示A[i,...,j-1]是不重复子字符串，其长度为j-i，则当考虑下一个A[j]时

* 如果A[j]与A[i,...,j-1]不存在重复字符，则可扩大不重复子字符串L(i,j-1)，扩大后L(i,j)长度为 j-i+1
* 如果A[j]与A[i,...,j-1]存在重复字符A[k]，则实际切断产生两个候选的最长不重复子字符串：
    * 一是L(i,j-1)，它已经不可能继续扩大，可以确定长度为 j-i；
    * 二是L(k,j)，如果扫描还没有完毕，L(k,j)还有扩大的可能，因此令i=k（方便继续考虑A[j+1]的过程），长度为 j-i+1


```
LONGEST-NO-REPEATING-SUBSTRING(s){

if s.length == 0
    return 0
maxLength = 1
i = 1
for j = 2 to s.length
    c =  s[j]
    for k = j - 1 to 1
        if c == s[k]
            i = k
    maxLength = max(maxLength, j - i + 1)

return maxLength

}
```

