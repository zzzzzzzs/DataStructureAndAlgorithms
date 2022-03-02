package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next; // 快指针一次走2步
      slow = slow.next;// 慢指针一次走1步
      if (fast == slow)
        return true;
    }
    return false;
  }

  void test() {
    int[] arr = {3, 2, 0, -4};
    ListNode listNode = ListNode.constructListNode(arr);
    boolean b = hasCycle(listNode);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new LinkedListCycle().test();
  }
}
