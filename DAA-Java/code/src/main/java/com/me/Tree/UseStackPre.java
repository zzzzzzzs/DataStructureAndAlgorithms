package com.me.Tree;

import java.util.Stack;

/**
 * @author zs
 * @date 2021/10/17. 使用栈先序遍历
 */
public class UseStackPre {
  public static class Node {
    public int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // 使用先序打印
  public static void printPre(Node node) {
    System.out.println("pre-order");
    if (node == null) {
      return;
    }

    Stack<Node> stack = new Stack();
    stack.add(node);
    while (!stack.isEmpty()) {
      node = stack.pop();
      System.out.println(node.value + "");
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }

  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(4);
    root.left.right = new Node(3);
    printPre(root);
  }

}
