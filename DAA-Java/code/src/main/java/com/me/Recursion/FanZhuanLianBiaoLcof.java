package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class FanZhuanLianBiaoLcof {

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

  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode node = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }



  public void test() {
    ListNode node1 = new ListNode(1);
    node1.next = new ListNode(2);
    node1.next.next = new ListNode(3);
    node1.next.next.next = new ListNode(4);
    node1.next.next.next.next = new ListNode(5);
    reverseList(node1);
    System.out.println();
  }

  public static void main(String[] args) {
    new FanZhuanLianBiaoLcof().test();
  }
}
