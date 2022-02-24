package com.me.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/24 N 叉树的层序遍历 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversa {

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

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null)
      return list;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < sz; i++) {
        Node node = queue.poll();
        level.add(node.val);
        // 添加节点
        if (node.children != null) {
          for (Node child : node.children) {
            if (child != null) {
              queue.offer(child);
            }
          }
        }
      }
      list.add(level);
    }
    return list;
  }

  void test() {
    Node root = new Node(1);
    root.children = new LinkedList<>();
    root.children.add(new Node(3));
    root.children.add(new Node(2));
    root.children.add(new Node(4));
    root.children.get(0).children = new LinkedList<>();
    root.children.get(0).children.add(new Node(5));
    root.children.get(0).children.add(new Node(6));
    List<List<Integer>> list = levelOrder(root);
    System.out.println(list);
  }

  public static void main(String[] args) {
    new NAryTreeLevelOrderTraversa().test();
  }

}
