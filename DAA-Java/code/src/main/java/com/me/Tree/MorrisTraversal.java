package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/5
 * morris 遍历
 * 适用于二叉树遍历，会产生自身的遍历序
 * 可以加工出前中后三种遍历序
 * 场景：不适用于头结点结果强依赖左右子节点结果的遍历
 * 时间复杂度O(N) 空间复杂度 O(1)
 */
public class MorrisTraversal {
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 中序
    // 只能来到自己一次节点，直接打印，能来到2次节点，第二次打印
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) { // 当cur != null 继续
            mostRight = cur.left; // mostright是cur左孩子
            if (mostRight != null) { //有左孩子执行
                while (mostRight.right != null && mostRight.right != cur) { // 跑的过程中，就是找左子树最右的节点
                    mostRight = mostRight.right;
                }
                // 从while出来后，mostright就是cur左子树上最右的节点
                if (mostRight.right == null) { // 违反了while的第一部分，说明第一次来到cur 中了2a
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 因为后面条件违反（cur2.right != cur）跳出的while，第二次来到cur
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " "); // 只要节点往右移动就打印 （中序只加这一句）
            cur = cur.right; // cur右移
        }
        System.out.println();
    }
    // 先序遍历
    public static void morrisPre(Node head) {
        // 先序
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.print(cur.value + " "); // 能回到自己两次节点，第一次就打印
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else { // 当前cur只能来到一次，打印行为
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    // 后序遍历
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left); // 逆序打印左子树右边届
                }
            }
            cur = cur.right;
        }
        printEdge(head); // 整棵树的右边届打印一下
        System.out.println();
    }

    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        morrisPos(head);
        printTree(head);

    }
}
