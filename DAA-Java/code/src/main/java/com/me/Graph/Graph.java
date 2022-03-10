package com.me.Graph;

import java.util.HashMap;
import java.util.HashSet;
/**
 * 图结构
 */
public class Graph {
    // <点的编号，实际的点>
    // node中的value对应这里的key
    public HashMap<Integer, Node> nodes; // 点集
    public HashSet<Edge> edges; // 边集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
