package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
//用单调栈记录遍历过的元素下标，然后通过这个下标可以直接从数组里拿值
// 始终记住存的是栈里存的是下标
//下标对应的值是单调递增的，所以叫单调栈
class Solution {
    static public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i<temperatures.length; i++) {
            if (!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])) {//判断的是temperatures[stack.peek()]是值，而不是下标
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.pop();
                }
                stack.push(i);//需要把当前的压进栈呀，不然当前下标的结果
            } else {
                stack.push(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(arr);
        for (int i: ans) {
            System.out.println(i);
        }
    }
}
