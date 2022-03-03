package com.me;

/**
 * @author zs
 * @date 2022/3/2
 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

  public static ListNode constructListNode(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return null;
    }

    ListNode dummyNode = new ListNode(-1);
    ListNode preNode = dummyNode;
    for (int i = 0; i < numbers.length; i++) {
      ListNode currNode = new ListNode(numbers[i]);
      preNode.next = currNode;
      preNode = preNode.next;
    }

    return dummyNode.next;
  }

  public static ListNode constructListNode(String str) {
    if (str == null || str.length() == 0) {
      return null;
    }

    String listStr = str.replaceAll(" ", "");
    String[] numbersStrArray;
    if (listStr.charAt(0) == '[' && listStr.charAt(listStr.length() - 1) == ']') {
      listStr = listStr.substring(1, listStr.length() - 1);
      numbersStrArray = listStr.split(",");
    } else if (listStr.contains("->")) {
      numbersStrArray = listStr.split("->");
    } else {
      numbersStrArray = new String[1];
      numbersStrArray[0] = listStr;
    }

    int numLength = 0;
    if (numbersStrArray.length > 1) {
      if (numbersStrArray[numbersStrArray.length - 1].equalsIgnoreCase("null")) {
        numLength = numbersStrArray.length - 1;
      } else {
        numLength = numbersStrArray.length;
      }
    } else {
      numLength = 1;
    }

    int[] numbers = new int[numLength];
    for (int i = 0; i < numLength; i++) {
      numbers[i] = Integer.parseInt(numbersStrArray[i]);
    }

    return constructListNode(numbers);
  }

  public static String printLinkedList(ListNode head) {
    if (head == null) {
      return "[]";
    } else if (head.next == null) {
      return "[" + head.val + "]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (head.next != null) {
      sb.append(head.val);
      if (head != null) {
        sb.append(",");
      }
      head = head.next;
    }
    sb.append(head.val).append("]");

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(printLinkedList(constructListNode("1->2->3->4->5->NULL ")));
    System.out.println(printLinkedList(constructListNode(" 1->2->3->4->5")));
    System.out.println(printLinkedList(constructListNode(" 1->2->3->4 ->5 -> null ")));
    System.out.println(printLinkedList(constructListNode("[1, 2, 3, 4 ,5]")));
    System.out.println(printLinkedList(constructListNode("[1, 2, 3, 4 , 5, null]")));
    System.out.println(printLinkedList(constructListNode("[1,  2, 3, 4 , 5, NULL]")));
    int[] arr = {1, 2, 3};
    System.out.println(printLinkedList(constructListNode(arr)));
  }

}
