package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast, slow;
    fast = slow = head;
    // fast 指针先走 n 步
    while (n-- > 0) {
      fast = fast.next;
    }
    if (fast == null) {
      return head.next;
    }
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }

  void test() {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode listNode = ListNode.constructListNode(arr);
    ListNode node = removeNthFromEnd(listNode, 2);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new RemoveNthNodeFromEndOfList().test();
  }
}
