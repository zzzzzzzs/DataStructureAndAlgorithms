package com.me.Graph;

/**
 * @author zs
 * @date 2021/10/20.
 */
public class Edge {
    public int weight; // 权值（一般是距离）
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
