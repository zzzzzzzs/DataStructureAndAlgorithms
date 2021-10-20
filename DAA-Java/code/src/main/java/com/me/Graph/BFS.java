package com.me.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zs
 * @date 2021/10/20.
 * 图-宽度优先遍历
 */
public class BFS {
    // 从node出发，进行宽度优先遍历
    public static void bfs(Node node) {
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
}
