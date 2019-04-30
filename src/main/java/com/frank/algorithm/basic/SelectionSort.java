package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：选择排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:01
 * @mofified By:
 */
public class SelectionSort {

    /**
     * @description：选择排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午2:55
     * @param array 参与排序的int类型数组
     * @mofified By:
     */
    public static int[] selectSort(int[] array) {
        int min;
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    // 最小值
                    min = array[j];
                    tmp = array[i];
                    array[i] = min;
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        // 将第3个元素及第8个元素之间的数进行从小到大进行排序
        int[] b = selectSort(a);
        for(int y : b) {
            System.out.println(y);
        }
    }
}
