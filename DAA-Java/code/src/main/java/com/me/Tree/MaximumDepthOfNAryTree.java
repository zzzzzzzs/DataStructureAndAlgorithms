package com.me.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/24
 */
public class MaximumDepthOfNAryTree {
  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public int maxDepth(Node root) {
    int maxDepth = 0;
    if (root == null)
      return maxDepth;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      maxDepth++;
      for (int i = 0; i < sz; i++) {
        Node node = queue.poll();
        if (node.children != null) {
          for (Node ele : node.children) {
            queue.offer(ele);
          }
        }
      }
    }
    return maxDepth;
  }

  void test() {
    Node root = new Node(1);
    root.children = new ArrayList<>();
    root.children.add(new Node(3));
    root.children.add(new Node(2));
    root.children.add(new Node(4));
    root.children.get(0).children = new ArrayList<>();
    root.children.get(0).children.add(new Node(5));
    root.children.get(0).children.add(new Node(6));
    int i = maxDepth(root);
    System.out.println(i);
  }

  public static void main(String[] args) {
    new MaximumDepthOfNAryTree().test();
  }
}
