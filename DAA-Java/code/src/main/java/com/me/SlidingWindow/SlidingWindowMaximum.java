package com.me.SlidingWindow;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int[] arr = new int[nums.length - k + 1];
    for (int i = 0; i < k; i++) {
      queue.add(nums[i]);
    }
    arr[0] = queue.poll();
    if (arr[0] != nums[0]) {
      queue.remove(nums[0]);
      queue.add(arr[0]);
    }
    for (int i = k; i < nums.length; i++) {
      queue.add(nums[i]);
      arr[i - k + 1] = queue.poll();
      if (arr[i - k + 1] != nums[i - k + 1]) {
        queue.remove(nums[i - k + 1]);
        queue.add(arr[i - k + 1]);
      }
    }
    return arr;
  }

  void test() {
    int[] arr = {1, -1};
    int[] ints = maxSlidingWindow(arr, 1);
    System.out.println(ints);
  }

  public static void main(String[] args) {
    new SlidingWindowMaximum().test();
  }
}
