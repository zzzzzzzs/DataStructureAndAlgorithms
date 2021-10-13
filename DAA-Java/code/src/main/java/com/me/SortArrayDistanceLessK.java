package com.me;

import java.util.PriorityQueue;

/**
 * @author zs
 * @date 2021/10/13.
 * 距离不超过K的数组排序，使用小顶堆
 */
public class SortArrayDistanceLessK {

    public void sortArrayDistanceLessK(int[] arr, int k) {
        // 默认小顶堆，在Java中就是优先级队列，任何结构都有
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 将前K个数放到小顶堆中
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        // 每次弹一个数放到i位置，新加一个数放到小顶堆中
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        // 最后没有数了，只需要每一个一个的弹出放到i上去
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
