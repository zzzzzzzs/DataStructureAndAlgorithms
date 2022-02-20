package com.me.Recursion;

import java.util.Stack;

/**
 * @author zs
 * @date 2022/2/20
 *
 *       回文链表
 *
 *       https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

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

  // 放到栈中
  public boolean isPalindrome(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode node = head;
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    while (node != null && !stack.isEmpty()) {
      ListNode pop = stack.pop();
      if (node.val != pop.val) {
        return false;
      }
      node = node.next;
    }
    return true;
  }

  public void test() {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(2);
    node.next.next.next = new ListNode(1);
    boolean b = isPalindrome(node);
    System.out.println(b);
  }

  public static void main(String[] args) {
    new PalindromeLinkedList().test();
  }
}
