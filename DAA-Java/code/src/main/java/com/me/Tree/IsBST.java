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

    public static void checkBST2(Node head) {
        List<Node> inOrderList = new ArrayList<>();
        process2(head, inOrderList);
        for (Node ele : inOrderList) {
            System.out.println(ele.value);
        }
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
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) { // 第一个分支不停的让左边界进栈
                    stack.push(head);
                    head = head.left;
                } else { // 左边界完了就进度右边界
                    head = stack.pop();
                    if (head.value <= preValue) {
                        return false;
                    } else {
                        preValue = head.value;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
