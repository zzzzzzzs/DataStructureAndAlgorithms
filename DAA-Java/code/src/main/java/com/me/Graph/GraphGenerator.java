package com.me.Graph;

/**
 * @author zs
 * @date 2021/10/20.
 */
public class GraphGenerator {
  // matrix 所有的边
  // N*3 的矩阵
  // [weight, from节点上面的值，to节点上面的值]
  public static Graph createGraph(Integer[][] matrix) {
    Graph graph = new Graph();
    for (int i = 0; i < matrix.length; i++) { // matrix[0][0], matrix[0][1] matrix[0][2]
      Integer from = matrix[i][0];
      Integer to = matrix[i][1];
      Integer weight = matrix[i][2];
      if (!graph.nodes.containsKey(from)) { // 如果第一次遇到过
        graph.nodes.put(from, new Node(from)); // 把点加进去
      }
      if (!graph.nodes.containsKey(to)) {
        graph.nodes.put(to, new Node(to));
      }
      Node fromNode = graph.nodes.get(from);
      Node toNode = graph.nodes.get(to);
      Edge newEdge = new Edge(weight, fromNode, toNode);
      fromNode.nexts.add(toNode); // 在from的邻居里就要把to点加上
      fromNode.out++;
      toNode.in++;
      fromNode.edges.add(newEdge);
      graph.edges.add(newEdge);
    }
    return graph;
  }

  public static void main(String[] args) {
    Integer[][] matrix = {{1, 0, 5}, {2, 1, 3}, {2, 0, 7}};
    Graph graph = createGraph(matrix);
    System.out.println();
  }
}
