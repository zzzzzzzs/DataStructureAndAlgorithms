package com.me.Graph;

/**
 * 边的集合
 */
public class Edge {
    public int weight; // 权值（一般是距离）
    // 有向边和无向边是一样的
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
