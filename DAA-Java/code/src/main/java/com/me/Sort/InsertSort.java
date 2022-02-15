package com.me.Sort;

/**
 * @author zs
 * @date 2021/10/11. 插入排序
 */
public class InsertSort {

  // i 和 j 是一个位置的话，会出错
  public static void swap(int[] arr, int i, int j) {
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }

  public static void insertSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    // 0 ~ 0 有序的
    // 0 ~ i 想有序
    for (int i = 0; i < arr.length; i++) { // 0 ~ i 做到有序
      for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
        swap(arr, j, j + 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 5, 4, 6};
    insertSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
