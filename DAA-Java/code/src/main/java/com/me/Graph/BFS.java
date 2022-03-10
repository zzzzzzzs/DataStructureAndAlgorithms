package com.me.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static com.me.Graph.GraphGenerator.createGraph;

/**
 * 图-宽度优先遍历
 */
public class BFS {
  // 从node出发，进行宽度优先遍历，整个大图的结构是用不到的，只要从一个点开始遍历就可以了
  public void bfs(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    HashSet<Node> set = new HashSet<>(); // 保证一个点不要重复进入队列
    queue.add(node);
    set.add(node);
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      System.out.println(cur.value); // 可以将打印行为替换成处理行为
      for (Node next : cur.nexts) {
        if (!set.contains(next)) {
          set.add(next);
          queue.add(next);
        }
      }
    }
  }

  void test() {
    Integer[][] matrix = {{1, 0, 5}, {2, 1, 3}, {2, 0, 7}};
    Graph graph = createGraph(matrix);
    bfs(graph.nodes.get(2));
    System.out.println();
  }

  public static void main(String[] args) {
    new BFS().test();
  }
}
