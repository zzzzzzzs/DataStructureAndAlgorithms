package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

  }

  public void test() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(2);
    node1.next.next = new ListNode(4);
    ListNode node2 = new ListNode(1);
    node2.next = new ListNode(3);
    node2.next.next = new ListNode(4);

    mergeTwoLists(node1, node2);
  }

  public static void main(String[] args) {
    new MergeTwoSortedLists().test();
  }

}
