package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：插入排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:02
 * @mofified By:
 */
public class InsertionSort {

    /**
     * @description：插入排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午3:23
     * @mofified By:
     */
    private static int[] insertSort(int[] a) {
        long t1 = System.nanoTime();
        // 直接插入排序
        for (int i = 1; i < a.length; i++) {
            // 待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入进来
            a[j + 1] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        int[] b = insertSort(a);
        for(int y : b) {
            System.out.println(y);
        }
    }
}
