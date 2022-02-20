package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

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
    return reverse(null, head);
  }

  public static ListNode reverse(ListNode pre, ListNode cur) {
    // 返回前一个节点
    if (cur == null) {
      return pre;
    }
    ListNode next = cur.next;
    cur.next = pre;
    return reverse(cur, next);
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
    new ReverseList().test();
  }
}
