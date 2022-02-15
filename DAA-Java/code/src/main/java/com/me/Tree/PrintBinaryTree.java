package com.me.Tree;

/**
 * @author zs
 * @date 2021/10/17. 直观打印二叉树（使用先序）
 */
public class PrintBinaryTree {
  public static class Node {
    public int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // 使用先序打印
  public static void printInOrder(Node node) {
    if (node == null) {
      return;
    }
    printProcess(node.value);
    printInOrder(node.left);
    printInOrder(node.right);
  }

  public static void printProcess(int value) {
    System.out.println(value);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(4);
    root.left.right = new Node(3);
    printInOrder(root);
  }

}
