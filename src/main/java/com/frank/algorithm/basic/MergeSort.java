package com.frank.algorithm.basic;

import java.util.Random;

/**
 * @version 1.0
 * @description：归并排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:00
 * @mofified By:
 */
public class MergeSort {

    /**
     * @description：归并排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午4:07
     * @mofified By:
     */
    public static void mergeSort(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    /**
     * @description：排序
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2019/4/30 下午4:10
     * @mofified By:
     */
    public static int[] sort(int[] a,int low,int high){
        // 分解
        int mid = (low+high)/2;
        if(low<high){
            // 治理
            sort(a,low,mid);
            // 治理
            sort(a,mid+1,high);
            // 左右归并（合并）
            mergeSort(a,low,mid,high);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i=0; i<10; i++) {
            a[i] = new Random().nextInt();
        }

        int[] b = sort(a, 0,a.length - 1);
        for(int y : b) {
            System.out.println(y);
        }
    }

}
