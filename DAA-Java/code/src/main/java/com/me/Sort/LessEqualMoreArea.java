package com.me.Sort;

/**
 * @author zs
 * @date 2021/11/5
 * 小于等于，大于区域问题，为快排准备
 */
public class LessEqualMoreArea {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R, int target){
        int le = L - 1; //小于等于区域
        while (L <= R){
            if(arr[L] <= target){
                swap(arr, ++le, arr[L++]);
            }else {
                L++;
            }
        }
        return --le;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,2,9,0,1};
        int partition = partition(arr, 0, arr.length - 1, 3);
        System.out.println(partition);
    }
}
