package com.me.Other;

import java.util.ArrayList;
import java.util.List;
// 一致性哈希算法
public class ConsistentHash {
  private List<Node> nodes = new ArrayList<>();
  private int virtualNodeNum = 100;

  public ConsistentHash(List<Node> nodes) {
    this.nodes = nodes;
  }

  public void addNode(Node node) {
    nodes.add(node);
  }

  public void removeNode(Node node) {
    nodes.remove(node);
  }

  public Node getNode(String key) {
    int hash = hash(key);
    int index = getNodeIndex(hash);
    return nodes.get(index);
  }

  private int hash(String key) {
    int hash = key.hashCode();
    return hash & 0x7fffffff;
  }

  private int getNodeIndex(int hash) {
    int nodeNum = nodes.size();
    int index = hash % (nodeNum * virtualNodeNum);
    return index / virtualNodeNum;
  }
}

class Node {
  private String name;

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class Test {
  public static void main(String[] args) {
    List<Node> nodes = new ArrayList<>();
    nodes.add(new Node("node1"));
    nodes.add(new Node("node2"));
    nodes.add(new Node("node3"));
    nodes.add(new Node("node4"));
    nodes.add(new Node("node5"));
    ConsistentHash consistentHash = new ConsistentHash(nodes);
    System.out.println(consistentHash.getNode("key1"));
    System.out.println(consistentHash.getNode("key2"));
    System.out.println(consistentHash.getNode("key3"));
    System.out.println(consistentHash.getNode("key4"));
    System.out.println(consistentHash.getNode("key5"));
    System.out.println(consistentHash.getNode("key6"));
    System.out.println(consistentHash.getNode("key7"));
    System.out.println(consistentHash.getNode("key8"));
    System.out.println(consistentHash.getNode("key9"));
    System.out.println(consistentHash.getNode("key10"));
    System.out.println(consistentHash.getNode("key11"));
    System.out.println(consistentHash.getNode("key12"));
    System.out.println(consistentHash.getNode("key13"));
    System.out.println(consistentHash.getNode("key14"));
    System.out.println(consistentHash.getNode("key15"));
    System.out.println(consistentHash.getNode("key16"));
    System.out.println(consistentHash.getNode("key17"));
    System.out.println(consistentHash.getNode("key18"));
    System.out.println(consistentHash.getNode("key19"));
    System.out.println(consistentHash.getNode("key20"));
    System.out.println(consistentHash.getNode("key21"));
    System.out.println(consistentHash.getNode("key22"));
  }
}
