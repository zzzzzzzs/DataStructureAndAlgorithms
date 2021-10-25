package com.me.Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zs
 * @date 2021/10/18.
 * 判断是否是搜索二叉树
 * is binary search tree
 * 使用中序遍历改造
 */
public class IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    // 判断是不是搜索二叉树
    public static ReturnData process(Node x) {
        if (x == null) {
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);

        int min = x.value;
        int max = x.value;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.value)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || x.value >= rightData.min)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }


    // 递归判断满二叉树问题
    public static boolean isF(Node head) {
        if (head == null) {
            return true;
        }
        Info data = f(head);
        return data.nodes == (1 << data.height) - 1; // 2^L -1
    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info f(Node x){
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }



    public static int preValue = Integer.MIN_VALUE;

    // 中序遍历
    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if (!isLeftBst) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return checkBST(head.right);
    }

    public static boolean checkBST2(Node head) {
        if (head == null) {
            return true;
        }
        List<Node> inOrderList = new ArrayList<>();
        process2(head, inOrderList);
        int pre = Integer.MIN_VALUE;
        for (Node cur : inOrderList) {
            if (pre >= cur.value) {
                return false;
            }
            pre = cur.value;
        }
        return true;
    }

    public static void process2(Node head, List<Node> inOrderList) {
        if (head == head) {
            return;
        }
        process2(head.left, inOrderList);
        inOrderList.add(head);
        process2(head.right, inOrderList);
    }


    // 中序遍历
    public static boolean checkBST3(Node head) {
        if (head == null) {
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) { // 第一个分支不停的让左边界进栈
                stack.push(head);
                head = head.left;
            } else { // 左边界完了就进度右边界
                head = stack.pop();
                if (head.value <= pre) {
                    return false;
                }
                preValue = head.value;
                head = head.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
