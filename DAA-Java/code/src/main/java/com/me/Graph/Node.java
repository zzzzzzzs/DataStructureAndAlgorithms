package com.me.Graph;

import java.util.ArrayList;

/**
 * @author zs
 * @date 2021/10/20.
 */
public class Node {
  public int value; // 具体的数据
  public int in; // 一个点的入度，就是有多少点所发散出来的边是直接指向这个点的，就是别人进到这里来有多少个
  public int out; // 一个点的出度
  public ArrayList<Node> nexts; // 指的是从当前这个点出发，由它发散出去的边直接邻居有哪些点
  public ArrayList<Edge> edges; // 属于这个点的边，也就是说由这个点发散出去的边

  public Node(int value) {
    this.value = value;
    in = 0;
    out = 0;
    nexts = new ArrayList<>();
    edges = new ArrayList<>();
  }
}
