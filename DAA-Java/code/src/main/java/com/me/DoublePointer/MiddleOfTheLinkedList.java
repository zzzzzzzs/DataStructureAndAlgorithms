package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 链表的中间结点
 *
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  void test() {
    int[] arr = {1, 2};
    ListNode listNode = ListNode.constructListNode(arr);
    ListNode node = middleNode(listNode);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new MiddleOfTheLinkedList().test();
  }
}
