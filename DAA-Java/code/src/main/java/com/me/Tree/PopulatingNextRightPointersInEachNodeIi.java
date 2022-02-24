package com.me.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21
 *
 *       填充每个节点的下一个右侧节点指针 II
 *
 *       https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeIi {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      Node node = null;
      for (int i = 0; i < sz; i++) {
        if (i == 0) {
          node = queue.poll();
        } else {
          node.next = queue.poll();
          node = node.next;
        }
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
      }
    }
    return root;
  }

  public void test() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    Node node = connect(root);
    System.out.println();
  }

  public static void main(String[] args) {
    new PopulatingNextRightPointersInEachNodeIi().test();
  }

}
