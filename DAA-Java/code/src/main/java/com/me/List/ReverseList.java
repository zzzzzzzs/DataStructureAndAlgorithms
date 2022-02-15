package com.me.List;

/**
 * @author zs
 * @date 2021/10/14. 反转链表（单向链表&双向链表）
 */
public class ReverseList {
  // 单向链表
  public static class SNode {
    public int value;
    public SNode next;

    public SNode(int value) {
      this.value = value;
    }
  }

  // 双向链表
  public static class DNode {
    int value;
    DNode next;
    DNode last;

    public DNode(int value) {
      this.value = value;
    }
  }

  // 反转单链表
  // a -> b -> c -> d -> null
  // d -> c -> b -> a -> null
  /*
   * 单向链表：
   * 首先引入 pre 和 next 指针，一开始都指向 null。此时来到第一个节点，让 next 指针指向下一个节点，让当前节点的下一个指针指向 pre 指针，
   * 此时当前节点与下一个节点断开，而当前节点的next指针指向的是null。然后 pre 指针指向当前节点，然后来到下一个节点的位置。
   * next 指针指向第三个节点，第二个节点的下一个节点指向 pre，pre 指向的是第一个节点，因此第二个节点指向的是第一个节点，随后 pre 指向当前节点的位置。
   * 然后继续，直到节点为 null。
   **/
  public static SNode reverseSList(SNode node) {
    SNode pre = null; // 前指针
    SNode next = null; // 下一个指针
    // 就类似与交换，引入一个中间变量 pre , 记得让指针移动就行了
    while (node != null) {
      next = node.next;
      // 让当前节点与下一个节点断开，指向前一个节点
      node.next = pre;
      pre = node;
      // 此时 node 来到下一个节点
      node = next;
      System.out.println();
    }
    return pre;
  }

  // 打印单向链表
  // TODO node 和 传入的 sNode 不是一个东西，虽然都指向一个地址，但是 node变量本身不是 sNode 变量。
  public static void printSList(SNode node) {
    while (node != null) {
      System.out.print(node.value);
      System.out.print(" -> ");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }
  // 打印双向链表
  public static void printDList(DNode node) {
    while (node != null) {
      System.out.print(node.value);
      System.out.print(" <=> ");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }

  public static void testSList() {
    SNode sNode = new SNode(1);
    sNode.next = new SNode(2);
    sNode.next.next = new SNode(3);
    sNode.next.next.next = new SNode(4);
    printSList(sNode);
    sNode = reverseSList(sNode);
    printSList(sNode);
  }
  // TODO 未完
  public static void testDList() {
    DNode dNode = new DNode(1);
    DNode dNode1 = new DNode(2);
    dNode.next = dNode1;
    dNode.last = dNode1;
    System.out.println(dNode.next.last.value);
  }

  public static void main(String[] args) {
//    testSList();
    testDList();
  }

}
