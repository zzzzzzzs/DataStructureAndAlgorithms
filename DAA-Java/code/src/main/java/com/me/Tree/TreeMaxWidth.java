package com.me.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zs
 * @date 2021/10/18. 如何完成二叉树的宽度优先遍历，就是按层遍历(常见题目:求一棵二叉树的宽度)
 */
public class TreeMaxWidth {

  private static class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
      this.value = data;
    }
  }

  /**
   * 宽度优先遍历 使用有限的变量，建立每一层结束的机制。 使用队列
   */
  public static int maxWidthNoMap(Node root) {
    int maxWidth = 0;
    if (root != null) {
      // 在Java中双链表是可以做队列的
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      int curWidth = 0;// 当前层的节点数
      Node curEnd = root; // 当前层，最右节点是谁
      Node nextEnd = null; // 下一层，最右节点是谁
      while (!queue.isEmpty()) {
        Node node = queue.poll();
        // 先放左在放右
        // 准备好下一层节点数据
        if (node.left != null) {
          queue.add(node.left);
          nextEnd = node.left;
        }
        if (node.right != null) {
          queue.add(node.right);
          nextEnd = node.right;
        }

        curWidth++;

        // 当前层到达最右侧，进入下一层
        // （当前层的最右节点的子节点，是下一层的最右节点）
        if (node == curEnd) {
          maxWidth = Math.max(maxWidth, curWidth);
          curWidth = 0;
          curEnd = nextEnd;
        }
      }
    }
    return maxWidth;
  }

    /**
   * 使用Map存储每个节点在哪一层，使用当前层与队列弹出的节点所对应的层来确认当前层是否结束 求一棵二叉树的最大宽度？
   */
  public static int maxWidthMap(Node root) {
    int maxWidth = 0;
    if (root != null) {
      // 在Java中双链表是可以做队列的
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);

      int curLevelNodes = 0;// 当前层发现了几个结点
      int curLevel = 1;// 当前在第一层
      HashMap<Node, Integer> map = new HashMap<>();// 记录每个节点在第几层
      map.put(root, curLevel);// 头节点所在的层数是第一层

      while (!queue.isEmpty()) {
        Node node = queue.poll();
        // 每弹出一个结点的时候，先得到结点的层数
        int nodeLevel = map.get(node);
        // 如果当前遍历到的结点所在的层和现在来到的层如果一样的话，那么在当前层的结点数++
        if (curLevel == nodeLevel) {
          curLevelNodes++;
        } else {
          maxWidth = Math.max(maxWidth, curLevelNodes);
          // 下一层的节点数置为一
          curLevelNodes = 1;
          // 如果不一样那么就来到下一层
          curLevel++;
        }
        // 先放左在放右
        if (node.left != null) {
          queue.add(node.left);
          map.put(node.left, nodeLevel + 1);
        }
        if (node.right != null) {
          queue.add(node.right);
          map.put(node.right, nodeLevel + 1);
        }
      }
      // 最后一层nodeLevel不会大于curLevel
      maxWidth = Math.max(maxWidth, curLevelNodes);
    }
    return maxWidth;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.left = new Node(2);
    head.right = new Node(3);
    head.left.left = new Node(4);
    head.left.right = new Node(5);
    head.right.left = new Node(6);
    head.right.right = new Node(7);
    int i = maxWidthMap(head);
    System.out.println(i);
  }
}
