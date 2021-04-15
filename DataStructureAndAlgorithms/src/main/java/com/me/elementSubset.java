package com.me;


// 获取m个元素dde的n个元素的子集
public class elementSubset {
    public static void main(String[] args) {
        int set[] = new int[300];
        int m, n, position;


        m = 300;
        n = 10;


        // 初始化
        for (int i = 0; i < n;++i){
            set[i] = i+1;
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%d,", set[i]);
        }
        System.out.println("-----------------");

        position = n-1;
        while(true) {
            if(set[n-1] == m)
                position--;
            else
                position = n - 1;
            set[position]++;
            // 调整右边元素
            for(int i = position + 1; i < n; i++)
                set[i] = set[i-1] + 1;
            for(int i = 0; i < n; i++){
                System.out.printf("%d,", set[i]);
            }
            System.out.println("------------------------------");
            if(set[0] >= m - n + 1)
                break;
        }

    }
}
