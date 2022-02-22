/*
 * ----------------------------------- WARNING: ----------------------------------- Your code may fail to compile
 * because it contains public class declarations. To fix this, please remove the "public" keyword from your class
 * declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {
  boolean flag = true;

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if (p == null || q == null) {
      return false;
    } else {
      if (p.val == q.val) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      } else {
        return false;
      }
    }
  }

  public void process(TreeNode p, TreeNode q) {
    if (p == null || q == null || flag == false) {
      return;
    }
    if (p.val != q.val) {
      flag = false;
      return;
    }
    // 在不等于null的基础上不相等
    if ((p.left == null) != (q.left == null)) {
      flag = false;
      return;
    }
    if ((p.right == null) != (q.right == null)) {
      flag = false;
      return;
    }
    process(p.left, q.left);
    process(p.right, q.right);
  }
}

public class MainClass {
  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode p = stringToTreeNode(line);
      line = in.readLine();
      TreeNode q = stringToTreeNode(line);

      boolean ret = new Solution().isSameTree(p, q);

      String out = booleanToString(ret);

      System.out.print(out);
    }
  }
}