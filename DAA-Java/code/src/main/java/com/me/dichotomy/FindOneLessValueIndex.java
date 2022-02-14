package com.me.dichotomy;

/**
 * @author zs
 * @date 2021/11/2 找局部最小值
 */
public class FindOneLessValueIndex {
  public static int getLessIndex(int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1; // no exist
    }
    if (arr.length == 1 || arr[0] < arr[1]) {
      return 0;
    }
    if (arr[arr.length - 1] < arr[arr.length - 2]) {
      return arr.length - 1;
    }
    int L = 1;
    int R = arr.length - 2;
    int mid = 0;
    while (L < R) {
      mid = L + (R - L) >> 1;
      if (arr[mid] > arr[mid - 1]) { // 有左极限
        R = mid - 1;
      } else if (arr[mid] > arr[mid + 1]) { // 有右极限
        L = mid + 1;
      } else {
        return mid;
      }
    }
    return L;
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i != arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 4, 6, 7, 8};
    printArray(arr);
    int index = getLessIndex(arr);
    System.out.println("index: " + index + ", value: " + arr[index]);
  }
}
