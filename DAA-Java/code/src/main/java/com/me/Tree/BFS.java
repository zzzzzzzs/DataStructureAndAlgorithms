package com.me.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/16
 * 二叉树宽度优先遍历
 */
public class BFS {
  public static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  public static void bfs(Node head) {
    if (head == null) {
      return;
    }
    Queue<Node> queue = new LinkedList();
    queue.add(head);
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      System.out.println(cur.value); // 处理过程
      if (cur.left != null) {
        queue.add(cur.left);
      }
      if (cur.right != null) {
        queue.add(cur.right);
      }
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.left = new Node(2);
    head.right = new Node(3);
    head.left.left = new Node(4);
    head.left.right = new Node(5);
    head.right.left = new Node(6);
    head.right.right = new Node(7);
    bfs(head);
  }

}
