package com.me.DoublePointer;

import com.me.ListNode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 * 
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

  // 使用最小堆
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    ListNode node = new ListNode();
    ListNode p = node;
    // 优先级队列，最小堆
    PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
    // 将 k 个链表的头结点加入最小堆
    for (ListNode head : lists) {
      if (head != null)
        pq.add(head);
    }
    while (!pq.isEmpty()) {
      ListNode poll = pq.poll();
      p.next = poll;
      if (poll.next != null) {
        pq.add(poll.next);
      }
      p = p.next;
    }
    return node.next;
  }

  public void test() {
    int[] arr1 = {1, 1, 2};
    int[] arr2 = {1, 1, 2};
    ListNode node1 = ListNode.constructListNode(arr1);
    ListNode node2 = ListNode.constructListNode(arr2);
    ListNode[] lists = new ListNode[] {node1, node2};
    System.out.println(ListNode.printLinkedList(mergeKLists(lists)));
  }

  public static void main(String[] args) {
    new MergeKSortedLists().test();
  }

}
