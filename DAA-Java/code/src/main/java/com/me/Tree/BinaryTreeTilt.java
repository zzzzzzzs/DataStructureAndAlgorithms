package com.me.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zs
 * @date 2022/2/21 二叉树的坡度 https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

  int res;

  public int findTilt(TreeNode root) {
    process(root);
    return res;
  }

  int process(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = process(root.left);
    int r = process(root.right);
    res += Math.abs(r - l);
    return l + r + root.val;
  }

  public void test() {
    Integer[] arr = {1, 2, 3};
    TreeNode root = TreeNode.constructTree(arr);
    int tilt = findTilt(root);
    System.out.println(tilt);
  }

  public static void main(String[] args) {
    new BinaryTreeTilt().test();
  }

}
