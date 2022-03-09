package com.me.Graph;

import java.util.HashMap;
import java.util.HashSet;
/**
 * @author zs
 * @date 2021/10/20.
 */
public class Graph {
    // <点的编号，实际的点>
    public HashMap<Integer, Node> nodes; // 点集
    public HashSet<Edge> edges; // 边集

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
