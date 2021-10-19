package com.me.Tree;

import javax.swing.*;
import java.util.Date;

/**
 * @author zs
 * @date 2021/10/19.
 * 判断是否是平衡二叉树
 */
public class IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static boolean ifFull(Node head) {
        ReturnData allInfo = p(head);
        return (1 << allInfo.height - 1) == allInfo.nums;
    }

    public static class ReturnData {
        public int height;
        public int nums;

        public ReturnData(int height, int nums) {
            this.height = height;
            this.nums = nums;
        }
    }

    public static ReturnData p(Node x) {
        if (x == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = p(x.left);
        ReturnData rightData = p(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;

        int nums = leftData.nums + rightData.nums + 1;
        return new ReturnData(height, nums);
    }


    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB, int hei) {
            isBalanced = isB;
            height = hei;
        }
    }

    public static ReturnType process(Node x) {
        if (x == null) { // base
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }


    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
