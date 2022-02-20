package com.me.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zs
 * @date 2022/2/20 从尾到头打印链表 https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public int[] reversePrint(ListNode head) {
    List<Integer> arr = new ArrayList();
    process(arr, head);
    int[] ints = new int[arr.size()];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = arr.get(i);
    }
    return ints;
  }

  public static void process(List<Integer> arr, ListNode head) {
    if (head == null) {
      return;
    }
    process(arr, head.next);
    arr.add(head.val);
  }

  public void test() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(3);
    node1.next.next = new ListNode(2);
    int[] ints = reversePrint(node1);
    System.out.println();
  }

  public static void main(String[] args) {
    new CongWeiDaoTouDaYinLianBiaoLcof().test();
  }
}
