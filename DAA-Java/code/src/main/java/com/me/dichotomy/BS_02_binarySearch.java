package com.me.dichotomy;

public class BS_02_binarySearch {
    /*
        TODO 二分查找递归版本，精髓就是排序，先排序，然后查找的时候就会快很多。
            每次搜索都会砍掉一半。时间复杂度：O(logN)
            精髓先排序，这就是为什么数据库建索引的时候会很慢，但是查的时候很快。
    * */
    public static boolean binarySearch(int[]arr, int target, int L, int R) {
        if (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, R);
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, L, mid - 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; ++i) {
            arr[i] = i;
        }
        System.out.println(binarySearch(arr, 100000000, 0, 99999999));
    }
}
