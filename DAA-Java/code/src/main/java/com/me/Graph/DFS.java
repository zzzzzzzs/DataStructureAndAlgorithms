package com.me.Graph;

import java.util.HashSet;
import java.util.Stack;

import static com.me.Graph.GraphGenerator.createGraph;

/**
 * 图-深度优先遍历
 */
public class DFS {
  public void dfs(Node node) {
    if (node == null) {
      return;
    }
    Stack<Node> stack = new Stack<>();
    HashSet<Node> set = new HashSet<>();
    stack.add(node);
    set.add(node);
    System.out.println(node.value); // 可以将打印行为替换成处理行为
    while (!stack.isEmpty()) {
      Node cur = stack.pop();
      for (Node next : cur.nexts) {
        if (!set.contains(next)) {
          stack.push(cur);
          stack.push(next);
          set.add(next);
          System.out.println(next.value); // 可以将打印行为替换成处理行为
          break;
        }
      }
    }
  }

  void test() {
    Integer[][] matrix = {{1, 0, 5}, {2, 1, 3}, {2, 0, 7}};
    Graph graph = createGraph(matrix);
    dfs(graph.nodes.get(1));
    System.out.println();
  }

  public static void main(String[] args) {
    new BFS().test();
  }
}
