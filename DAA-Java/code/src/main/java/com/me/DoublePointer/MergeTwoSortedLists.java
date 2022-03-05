package com.me.DoublePointer;

import com.me.ListNode;

/**
 * 合并两个有序链表
 * 
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode node = new ListNode();
    ListNode p = node;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        p.next = list1;
        list1 = list1.next;
      } else {
        p.next = list2;
        list2 = list2.next;
      }
      p = p.next;
    }
    if (list1 == null) {
      p.next = list2;
    }
    if (list2 == null) {
      p.next = list1;
    }
    return node.next;
  }

  public void test() {
    int[] arr1 = {1, 1, 2};
    int[] arr2 = {1, 1, 2};
    ListNode node1 = ListNode.constructListNode(arr1);
    ListNode node2 = ListNode.constructListNode(arr2);
    System.out.println(ListNode.printLinkedList(mergeTwoLists(node1, node2)));
  }

  public static void main(String[] args) {
    new MergeTwoSortedLists().test();
  }

}
