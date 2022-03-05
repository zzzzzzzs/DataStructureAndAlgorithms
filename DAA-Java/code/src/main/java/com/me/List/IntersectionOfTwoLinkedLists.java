package com.me.List;

import com.me.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;
    while (p1 != p2) {
      if(p1 == null) p1 = headB;
      else p1 = p1.next;
      if(p2 == null) p2 = headA;
      else p2 = p2.next;
    }
    return p1;
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    Set<ListNode> set = new HashSet<>();
    while (headA != null) {
      set.add(headA);
      headA = headA.next;
    }
    while (headB != null) {
      if (set.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }
    return null;
  }

  void test() {
    int[] arr1 = {1, 1, 2};
    int[] arr2 = {1, 1, 2};
    ListNode node1 = ListNode.constructListNode(arr1);
    ListNode node2 = ListNode.constructListNode(arr2);
    ListNode node = getIntersectionNode(node1, node2);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new IntersectionOfTwoLinkedLists().test();
  }
}
