package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：冒泡排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:01
 * @mofified By:
 */
public class BubbleSort {

    /**
     * @description：冒泡排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午3:07
     * @mofified By:
     */
    private static int[] bulleSort(int[] numbers) {
        // 记录临时变量
        int temp;
        // 数组大小
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            // 索引不同的两层for循环
            for (int j = i + 1; j < size; j++) {
                // 交互数据从大到小排列顺序  大的放前面
                if (numbers[i] < numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        int[] b = bulleSort(a);
        for(int y : b) {
            System.out.println(y);
        }
    }
}
