package com.me.Tree;

/**
 * @author zs
 * @date 2022/2/23
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * 
 * https://leetcode-cn.com/playground/VDCGQ8Ds/
 */
public class TreeNode {
  public int val;

  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    this.val = x;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  // ====== 水平树 ======
  public static int getTreeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
  }

  private static String traversePreOrder(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(root.val);

    String pointerRight = "└──";
    String pointerLeft;
    if (root.right != null) {
      pointerLeft = "├──";
    } else {
      pointerLeft = "└──";
    }

    traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
    traverseNodes(sb, "", pointerRight, root.right, false);

    return sb.toString();
  }

  private static void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
    boolean hasRightSibling) {
    if (node == null) {
      return;
    }

    sb.append("\n");
    sb.append(padding);
    sb.append(pointer);
    sb.append(node.val);

    StringBuilder paddingBuilder = new StringBuilder(padding);
    if (hasRightSibling) {
      paddingBuilder.append("│  ");
    } else {
      paddingBuilder.append("   ");
    }

    String paddingForBoth = paddingBuilder.toString();
    String pointerRight = "└──";
    String pointerLeft = (node.right != null) ? "├──" : "└──";

    traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
    traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
  }

  public static void printTreeHorizontal(TreeNode root) {
    System.out.print(traversePreOrder(root));
  }

  // ====== 垂直树 ======
  public static void printTree(TreeNode root) {
    int maxLevel = getTreeDepth(root);
    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
    if (nodes == null || nodes.isEmpty() || isAllElementsNull(nodes)) {
      return;
    }

    int floor = maxLevel - level;
    int endgeLines = (int)Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int)Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int)Math.pow(2, (floor + 1)) - 1;

    printWhitespaces(firstSpaces);

    List<TreeNode> newNodes = new ArrayList<TreeNode>();
    for (TreeNode node : nodes) {
      if (node != null) {
        System.out.print(node.val);
        newNodes.add(node.left);
        newNodes.add(node.right);
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }

      printWhitespaces(betweenSpaces);
    }
    System.out.println("");

    for (int i = 1; i <= endgeLines; i++) {
      for (int j = 0; j < nodes.size(); j++) {
        printWhitespaces(firstSpaces - i);
        if (nodes.get(j) == null) {
          printWhitespaces(endgeLines + endgeLines + i + 1);
          continue;
        }

        if (nodes.get(j).left != null) {
          System.out.print("/");
        } else {
          printWhitespaces(1);
        }

        printWhitespaces(i + i - 1);
        if (nodes.get(j).right != null) {
          System.out.print("\\");
        } else {
          printWhitespaces(1);
        }
        printWhitespaces(endgeLines + endgeLines - i);
      }

      System.out.println("");
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++) {
      System.out.print(" ");
    }
  }

  private static <T> boolean isAllElementsNull(List<T> list) {
    for (Object object : list) {
      if (object != null) {
        return false;
      }
    }

    return true;
  }

  public static TreeNode constructTree(Integer[] array) {
    if (array == null || array.length == 0 || array[0] == null) {
      return null;
    }

    int index = 0;
    int length = array.length;

    TreeNode root = new TreeNode(array[0]);
    Deque<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.offer(root);
    TreeNode currNode;
    while (index < length) {
      index++;
      if (index >= length) {
        return root;
      }
      currNode = nodeQueue.poll();
      Integer leftChild = array[index];
      if (leftChild != null) {
        currNode.left = new TreeNode(leftChild);
        nodeQueue.offer(currNode.left);
      }
      index++;
      if (index >= length) {
        return root;
      }
      Integer rightChild = array[index];
      if (rightChild != null) {
        currNode.right = new TreeNode(rightChild);
        nodeQueue.offer(currNode.right);
      }
    }

    return root;
  }

  public static void main(String[] args) {
    Integer[] tstData1 = {-64, 12, 18, -4, -53, null, 76, null, -51, null, null, -93, 3, null, -31, 47, null, 3, 53,
      -81, 33, 4, null, -51, -44, -60, 11, null, null, null, null, 78, null, -35, -64, 26, -81, -31, 27, 60, 74, null,
      null, 8, -38, 47, 12, -24, null, -59, -49, -11, -51, 67, null, null, null, null, null, null, null, -67, null, -37,
      -19, 10, -55, 72, null, null, null, -70, 17, -4, null, null, null, null, null, null, null, 3, 80, 44, -88, -91,
      null, 48, -90, -30, null, null, 90, -34, 37, null, null, 73, -38, -31, -85, -31, -96, null, null, -18, 67, 34, 72,
      null, -17, -77, null, 56, -65, -88, -53, null, null, null, -33, 86, null, 81, -42, null, null, 98, -40, 70, -26,
      24, null, null, null, null, 92, 72, -27, null, null, null, null, null, null, -67, null, null, null, null, null,
      null, null, -54, -66, -36, null, -72, null, null, 43, null, null, null, -92, -1, -98, null, null, null, null,
      null, null, null, 39, -84, null, null, null, null, null, null, null, null, null, null, null, null, null, -93,
      null, null, null, 98};
    TreeNode tstNode1 = constructTree(tstData1);
    System.out.println("\nTree:");
    printTree(tstNode1);
    System.out.println("\nHorizontal Tree:");
    printTreeHorizontal(tstNode1);
    System.out.println("\nPreOrder:");
    // preOrderPrint(tstNode1);

    Integer[] tstData2 = {-64, 12, 18, -4, -53, null, 76, null, -51, null, null, -93, 3, null, -31, 47, null, 3, 53,
            -81, 33, 4, null, -51, -44, -60, 11, null, null, null, null, 78, null, -35, -64, 26, -81, -31, 27, 60, 74, null,
            null, 8, -38, 47, 12, -24, null, -59, -49, -11, -51, 67, null, null, null, null, null, null, null, -67, null, -37,
            -19, 10, -55, 72, null, null, null, -70, 17, -4, null, null, null, null, null, null, null, 3, 80, 44, -88, -91,
            null, 48, -90, -30, null, null, 90, -34, 37, null, null, 73, -38, -31, -85, -31, -96, null, null, -18, 67, 34, 72,
            null, -17, -77, null, 56, -65, -88, -53, null, null, null, -33, 86, null, 81, -42, null, null, 98, -40, 70, -26,
            24, null, null, null, null, 92, 72, -27, null, null, null, null, null, null, -67, null, null, null, null, null,
            null, null, -54, -66, -36, null, -72, null, null, 43, null, null, null, -92, -1, -98, null, null, null, null,
            null, null, null, 39, -84, null, null, null, null, null, null, null, null, null, null, null, null, null, -93,
            null, null, null, 98};
    TreeNode tstNode2 = constructTree(tstData2);
    System.out.println("\nTree:");
    printTree(tstNode2);
    System.out.println("\nHorizontal Tree:");
    printTreeHorizontal(tstNode2);
    // System.out.println("\nPreOrder:");
    // preOrderPrint(tstNode2);
    // System.out.println("\nInOrder:");
    // inOrderPrint(tstNode2);
    // System.out.println("\nPostOrder:");
    // postOrderPrint(tstNode2);
  }

}

// 作者：羽路阳光
// 链接：https://leetcode-cn.com/circle/discuss/vpcMyM/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。