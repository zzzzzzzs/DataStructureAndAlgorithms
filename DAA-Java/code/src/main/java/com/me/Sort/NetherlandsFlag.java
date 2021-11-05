package com.me.Sort;

/**
 * @author zs
 * @date 2021/11/3
 * 荷兰国旗问题，三色
 */
public class NetherlandsFlag {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // L:当前位置
    public static int[] partition(int[] arr, int L, int R, int target) {
        int less = L - 1; // < 区域
        int more = R + 1; // > 区域
        while (L < more) { //如果当前位置到达或超过more位置，跳出循环
            if (arr[L] < target) { //如果当前位置数小于指定的数字
                swap(arr, ++less, L++); // 将当前位置数和小于区域的下一个数交换，并且小于区域向扩,将当前位置向右移动
            } else if (arr[L] > target) { // 如果当前位置数大于指定的数字
                swap(arr, --more, L); // 将当前位置数和大于区域的前一个数交换，并且大于区域向左扩。当前位置之所以不变是因为交换以后的位置还是小于目标值的，等待交换中。
            } else {
                L++; // 将当前位置向右移动
            }
        }
        return new int[] { less + 1, more - 1 }; // 最终返回等于区域的范围
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,3,4,5,2,6,9,0};
        int[] res = partition(arr, 0, arr.length - 1, 5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

