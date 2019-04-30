package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：希尔排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:02
 * @mofified By:
 */
public class ShellSort {

    /**
     * @description：希尔排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午3:38
     * @mofified By:
     */
    private static int[] shellSort(int[] a) {
        int d = a.length / 2;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < a.length; j += d) {
                    int temp;
                    if (a[j] > a[j + d]) {
                        temp = a[j];
                        a[j] = a[j + d];
                        a[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        int[] b = shellSort(a);
        for(int y : b) {
            System.out.println(y);
        }
    }

}
