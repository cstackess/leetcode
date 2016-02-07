import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/2/6.
 */
public class Solution {

    //循环s和分割p后的pL：对s的每个单字符a
    //如果遇到pL中是a或.，则i++,j++
    //如果遇到pL中是a*或.*，则i++
    //如果遇到pL中是b*，则j++
    //如果遇到pL中是b，则失败
    //如果i(j)结束而j(i)未结束，则失败【有问题……】
    public boolean isMatch(String s, String p) {
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();
        if (pChars.length == 0 ^ sChars.length == 0)//相异为1
            return false;
        if (pChars.length == 0 && sChars.length == 0)
            return true;
        // 分割p
        int left = 0;
        int right;
        List<String> pList = new ArrayList<String>();
        for (int i = 1; i < pChars.length; i++) {
            if (pChars[i] == '*')
                continue;
            right = i;
            pList.add(String.valueOf(pChars, left, right - left));
            left = right;
        }
        pList.add(String.valueOf(pChars, left, pChars.length - left));
        int i, j;
        boolean isMatched = true;
        for (i = 0, j = 0; i < sChars.length && j < pList.size(); ) {
            char sChar = sChars[i];
            String pString = pList.get(j);
            if (pString.equals("" + sChar) || pString.equals(".")) {
                i++;
                j++;
            } else if (pString.equals("" + sChar + "*") || pString.equals(".*")) {
                i++;
            } else if (pString.length() == 2) {
                j++;
            } else {
                isMatched = false;
                break;
            }
        }
        //终止条件有问题……
        if (i == sChars.length && j < pList.size()) {
            for (int x = j, y = sChars.length - 1; x < pList.size() && y >= 0; ) {
                String pString = pList.get(x);
                char sChar = sChars[y];
                if (pString.equals("" + sChar) || pString.equals(".")) {
                    y--;
                    x++;
                } else if (pString.equals("" + sChar + "*") || pString.equals(".*")) {
                    y--;
                } else if (pString.length() == 2) {
                    x++;
                } else {
                    isMatched = false;
                    break;
                }
            }
        }

        if (!isMatched || (i < sChars.length && j == pList.size()))
            return false;
        return true;

        //分割s
//        left = 0;
//        right = 1;
//        List<String> sList = new ArrayList<String>();
//        for (int j = 0; j < sChars.length; j++) {
//            if (sChars[left] == sChars[j])
//                continue;
//            right = j;
//            sList.add(String.valueOf(sChars, left, right - left));
//            left = right;
//        }
//        sList.add(String.valueOf(sChars, left, sChars.length - left));
//        System.out.println(sList);

    }
}
