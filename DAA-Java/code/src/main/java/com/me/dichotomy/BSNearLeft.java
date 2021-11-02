package com.me.dichotomy;

/**
 * @author zs
 * @date 2021/11/2
 * 在一个有序数组中，找>=某个数最左侧的位置
 */
public class BSNearLeft {
    // 在 sortedArr 上，找满足>=value的最左位置
    public static int nearestIndex(int[] sortedArr, int value) {
        int L = 0;
        int R = sortedArr.length - 1;
        int index = -1;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (sortedArr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] sortedArr = {0,0,0,1,1,2,2,2,2,2,2,3,3,3,3,3,4,4,4};
        int i = nearestIndex(sortedArr, 4);
        System.out.println(i);
    }
}
