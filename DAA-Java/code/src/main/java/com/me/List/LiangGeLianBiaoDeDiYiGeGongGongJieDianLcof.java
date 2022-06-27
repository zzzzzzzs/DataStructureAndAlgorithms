package com.me.List;

import com.me.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * <p>https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {

  // 绕了一圈
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;
    while (p1 != p2) {
      if (p1 == null) p1 = headB;
      else p1 = p1.next;
      if (p2 == null) p2 = headA;
      else p2 = p2.next;
    }
    return p1;
  }

  void test() {
    int[] arr1 = {4, 1, 8, 4, 5};
    int[] arr2 = {5, 0, 1, 8, 4, 5};
    ListNode node1 = ListNode.constructListNode(arr1);
    ListNode node2 = ListNode.constructListNode(arr2);
    ListNode node = getIntersectionNode(node1, node2);
    System.out.println(ListNode.printLinkedList(node));
  }

  public static void main(String[] args) {
    new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().test();
  }
}
