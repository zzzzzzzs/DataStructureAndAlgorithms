package com.me.Recursion;

/**
 * @author zs
 * @date 2022/2/20 移除链表元素 https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListEle {

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

  public ListNode removeElements(ListNode head, int val) {
    if (head == null)
      return head;
    head.next = removeElements(head.next, val);
    // 链表倒着循环
    if (head.val == val) {
      return head.next;
    }
    return head;
  }

  public void test() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(6);
    node.next.next.next = new ListNode(3);
    node.next.next.next.next = new ListNode(4);
    node.next.next.next.next.next = new ListNode(5);
    node.next.next.next.next.next.next = new ListNode(6);
    removeElements(node, 6);
    System.out.println();
  }

  public static void main(String[] args) {
    new RemoveLinkedListEle().test();
  }
}
