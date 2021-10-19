package com.me.Tree;

import java.util.LinkedList;

/**
 * @author zs
 * @date 2021/10/19.
 * 判断完全二叉树
 * is complete binary tree
 */
public class IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    // 判断是否是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) {
            return false;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                //如果遇到了不双全的节点之后，又发现当前节点居然有孩子
                    (leaf && (l != null || r != null))
                            || (l == null && r != null)
            ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) { // 不双全
                leaf = true;
            }
        }
        return true;
    }
}
