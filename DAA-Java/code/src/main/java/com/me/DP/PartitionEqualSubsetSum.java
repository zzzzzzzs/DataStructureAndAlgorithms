package com.me.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zs
 * @date 2024/5/19
 * 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Map<String, Boolean> cache = new HashMap<>();
        return process(target, 0, nums, cache);
//        return process(target, 0, nums);
    }

    public static boolean process(int target, int idx, int[] nums) {
        if (target == 0) return true; // 这里是成功的标志
        if (target < 0 || idx == nums.length) return false; // 这里对于结果为负数，或者迭代次数超过了数组的长度
        // 对应左递归，相当于减去当前值 || 对应右递归，不需要当前值，对应不做任何操作
        return process(target - nums[idx], idx + 1, nums) || process(target, idx + 1, nums);
    }

    // 动态规划，缓存方法，用 HashMap 费内存
    public static boolean process(int target, int idx, int[] nums, Map<String, Boolean> cache) {
        String key = target + "|" + idx; // key 就是可变参数组装的， 返回结果就是该问题要求解的结果
        if (cache.containsKey(key)) return cache.get(key);
        if (target == 0) return true; // 这里是成功的标志
        if (target < 0 || idx == nums.length) return false; // 这里对于结果为负数，或者迭代次数超过了数组的长度
        // 对应左递归，相当于减去当前值 || 对应右递归，不需要当前值，对应不做任何操作
        boolean res = process(target - nums[idx], idx + 1, nums, cache) || process(target, idx + 1, nums, cache);
        cache.put(key, res);
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums1));
    }
}
