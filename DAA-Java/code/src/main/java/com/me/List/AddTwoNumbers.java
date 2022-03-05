package com.me.List;

import java.util.HashSet;
import java.util.Set;

import com.me.ListNode;

/**
 * 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode();
    ListNode p = node;
    int carry = 0; // 进位
    while (l1 != null || l2 != null || carry > 0) {
      int val = carry;
      if (l1 != null) {
        val += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        val += l2.val;
        l2 = l2.next;
      }
      carry = val / 10;
      val = val % 10;
      p.next = new ListNode(val);
      p = p.next;
    }
    return node.next;
  }

  void test() {
    int[] arr1 = {0};
    int[] arr2 = {0};
    ListNode node1 = ListNode.constructListNode(arr1);
    ListNode node2 = ListNode.constructListNode(arr2);
    ListNode node = addTwoNumbers(node1, node2);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new AddTwoNumbers().test();
  }
}
