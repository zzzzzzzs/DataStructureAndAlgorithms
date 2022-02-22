package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 
 *       https://labuladong.github.io/algo/2/17/17/
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
    if (head == null || head.next == null) {
      return head;
    }
    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  public void test() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    // node.next.next = new ListNode(3);
    // node.next.next.next = new ListNode(4);
    // node.next.next.next.next = new ListNode(5);
    node = reverseList(node);
    System.out.println();
  }

  public static void main(String[] args) {
    new FanZhuanLianBiaoLcof().test();
  }
}
