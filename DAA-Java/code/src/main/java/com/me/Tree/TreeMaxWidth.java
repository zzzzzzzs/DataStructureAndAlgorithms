package com.me.Tree;

import sun.awt.image.ImageWatched;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zs
 * @date 2021/10/18.
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

    // 宽度优先遍历
    public static void w(Node head) {
        if (head == null) {
            return;
        }
        // 在Java中双链表是可以做队列的
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value); // 弹出就打印
            // 先放左在放右
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // 求一棵二叉树的最大宽度？
    public static int ww(Node head) {
        if (head == null) {
            return 0;
        }
        // 在Java中双链表是可以做队列的
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1); // 头节点所在的层数是第一层
        int curLevel = 1;//当前在第一层
        int curLevelNodes = 0;//当前层发现了几个结点
        int max = Integer.MIN_VALUE; // 所有层中哪一个层中结点数是最多的。
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 每弹出一个结点的时候，先得到结点的层数
            int curNodeLevel = levelMap.get(cur);
            // 如果当前遍历到的结点所在的层和现在来到的像统计的层如果一样的话，那么在当前层的结点数++
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            // 先放左在放右
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return Math.max(max, curLevelNodes);
    }

//    // LC662 二叉树最大宽度：同一层中最大宽度
//    public int widthOfBinaryTree(TreeNode root) {
//        maxWidth = 0;
//        map = new HashMap<>();
//        dfs(root, 0, 0);
//        return maxWidth;
//    }
//
//    private void dfs(TreeNode root, int depth, int index) {
//        if (root == null) return;
//        // putIfAbsent():如果key对应的value已经存在，就返回老的value，否则才更新key,value
//        map.putIfAbsent(depth, index);
//        maxWidth = Math.max(maxWidth, index - map.get(depth) + 1);
//        dfs(root.left, depth + 1, 2 * index + 1);// 先来最左边，所以map保存了最左边结点的坐标
//        dfs(root.right, depth + 1, 2 * index + 2);
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(5);
//        TreeNode n4 = new TreeNode(3);
//        TreeNode n5 = new TreeNode(9);
//        root.left = n1;
//        root.right = n2;
//        n1.left = n3;
//        n1.right = n4;
//        n2.right = n5;
//
//        TreeMaxWidth treeMaxWidth = new TreeMaxWidth();
//        int count = treeMaxWidth.widthOfBinaryTree(root);
//        System.out.println(count);
//
//    }
}
