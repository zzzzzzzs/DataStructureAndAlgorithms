package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

  // 有序就可以使用双指针
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null) return null;
    ListNode slow, fast;
    slow = fast = head;
    while (fast != null) {
      if (slow.val != fast.val) {
        slow = slow.next;
        slow.val = fast.val;
      }
      fast = fast.next;
    }
    slow.next = null;
    return head;
  }

  void test() {
    int[] arr = {1, 1, 2};
    ListNode listNode = ListNode.constructListNode(arr);
    ListNode node = deleteDuplicates(listNode);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new RemoveDuplicatesFromSortedList().test();
  }
}
