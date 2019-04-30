package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：快速排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 上午11:58
 * @mofified By:
 */
public class QuickSort {

    /**
     * @description：快速排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午1:42
     * @param a 参与排序的int类型的数组
     * @param left 排序元素区间【下标起始位置】
     * @param right 排序元素区间【下标截止位置】
     * @mofified By:
     */
    private static int[] quickSort(int[] a ,int left,int right) {
        if(left < right) {
            int i,j,t,temp;
            // temp中存的就是基准数
            temp = a[left];
            i = left;
            j = right;
            while(i!=j) {
                // 顺序很重要，要先从右边开始找
                while(a[j]>=temp && i<j) {
                    j--;
                }
                // 再找右边的
                while(a[i]<=temp && i<j) {
                    i++;
                }
                // 交换两个数在数组中的位置
                if(i<j) {
                    t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
            // 最终将基准数归位
            a[left]=a[i];
            a[i]=temp;
            // 继续处理左边的，这里是一个递归的过程
            quickSort(a,left,i-1);
            // 继续处理右边的 ，这里是一个递归的过程
            quickSort(a,i+1,right);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        // 将第3个元素及第8个元素之间的数进行从小到大进行排序
        int[] b = quickSort(a, 3, 8);
        // 排序所有的元素
        int[] b2 = quickSort(a,0,a.length-1);
        for(int y : b) {
            System.out.println(y);
        }
    }
}
