package com.me.Graph;

import java.util.*;

/**
 * @author zs
 * @date 2021/10/21
 * 拓扑排序，前提是没有环的情况下
 */
public class TopologySort {

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        // key：某一个node
        // value：剩余的入度
        // 也就是说某一个点剩余的入度为多少
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) { //对于整张图来说，先把所有的点看一下
            inMap.put(node, node.in);
            if (node.in == 0) { // 入度为0的点，进入队列
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll(); // 入度为0的点，弹出一个
            result.add(cur); // 将弹出入度为0的点加到拓扑排序的结果中
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1); // 擦除影响
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
