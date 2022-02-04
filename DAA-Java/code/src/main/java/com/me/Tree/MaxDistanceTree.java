package com.me.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * @author zs
 * @date 2022/2/1
 * 二叉树的递归套路:3.任何两个节点之间都存在距离，求X子树的两个节点的最大距离
 */
public class MaxDistanceTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * 递归后序
     */
    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    private static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        /**
         * - X左树的最大距离. 与X无关:
         * - X右树的最大距离, 与X无关:
         * - X的左树高度与X的右树右树高度的和 再+1. 与X有关:
         */
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(leftInfo.height + rightInfo.height + 1,
                Math.max(leftInfo.maxDistance, rightInfo.maxDistance));

        return new Info(maxDistance, height);
    }

    /**
     * 树的高度和两节点之间的最大距离.
     */
    public static class Info {
        int maxDistance;
        int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    /**
     * 对数器
     * 穷举所有情况下两节点的距离,求最大.
     */
    public static int maxDistanceUseMap(Node head) {
        if (head == null)
            return 0;

        ArrayList<Node> nodeArr = new ArrayList<>();
        fillPreList(head, nodeArr);

        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);

        int max = 0;
        for (int i = 0; i < nodeArr.size(); i++) {
            // 可能只有一个节点, 所以j=i+1有错
            for (int j = i; j < nodeArr.size(); j++) {
                max = Math.max(max, getDistance(parentMap, nodeArr.get(i), nodeArr.get(j)));
            }
        }
        return max;
    }

    /**
     * 先序遍历得所有节点的数组
     */
    private static void fillPreList(Node node, ArrayList<Node> nodeArr) {
        if (node == null)
            return;

        nodeArr.add(node);
        fillPreList(node.left, nodeArr);
        fillPreList(node.right, nodeArr);
    }

    /**
     * 递归填充 节点和其父节点 的关系Map
     */
    private static void fillParentMap(Node node, HashMap<Node, Node> parentMap) {
        if (node.left != null) {
            parentMap.put(node.left, node);
            fillParentMap(node.left, parentMap);
        }

        if (node.right != null) {
            parentMap.put(node.right, node);
            fillParentMap(node.right, parentMap);
        }
    }

    /**
     * 获取两节点之间的距离
     */
    private static int getDistance(HashMap<Node, Node> parentMap, Node node1,
                                   Node node2) {
        Node cur = node1;
        HashSet<Node> set1 = new HashSet<>();
        set1.add(cur);
        // 获取node1及其所有父节点
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            set1.add(cur);
        }

        // 找到node和node2的最近的父节点
        cur = node2;
        while (!set1.contains(cur)) {
            cur = parentMap.get(cur);
        }
        Node lowestAncestor = cur;

        // node1到最近父节点的距离
        cur = node1;
        int distance1 = 1;
        while (cur != lowestAncestor) {
            distance1++;
            cur = parentMap.get(cur);
        }

        // node2到最近父节点的距离
        cur = node2;
        int distance2 = 1;
        while (cur != lowestAncestor) {
            distance2++;
            cur = parentMap.get(cur);
        }

        // 多计算一次最近的父节点
        return distance1 + distance2 - 1;
    }

    public static void main(String[] args) {
        // 层数越大, 执行越慢, 二叉树深度为10后, 非常慢.
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 100000;
        System.out.println("start test");
//        for (int i = 0; i < testTimes; i++) {
//            Node head = TreeTestHelper.generateRandomBTS(maxLevel, maxValue);
//            int max1 = maxDistance(head);
//            int max2 = maxDistanceUseMap(head);
//            if (max1 != max2) {
//                System.out.println(max1 + " error " + max2);
//                TreeTestHelper.printTree(head);
//                break;
//            }
//        }
        System.out.println("finish");
    }
}
