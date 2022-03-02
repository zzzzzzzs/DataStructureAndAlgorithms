package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 环形链表 II
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleIi {

  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow)
        break;
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  void test() {
    int[] arr = {3, 2, 0, -4};
    ListNode listNode = ListNode.constructListNode(arr);
    ListNode node = detectCycle(listNode);
    System.out.println(node);
  }

  public static void main(String[] args) {
    new LinkedListCycleIi().test();
  }
}
