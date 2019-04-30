package com.frank.algorithm.basic;

/**
 * @version 1.0
 * @description：堆排序
 * @author: Yang.Chang
 * @project: spring-boot-algorithm
 * @package: com.frank.algorithm.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/30 下午12:00
 * @mofified By:
 */
public class HeapSort {

    private int[] arr;

    public void heapAdjust(int[] arr,int s,int m){
        // 已知arr[s...m]中记录的关键字除arr[s]之外均满足堆的定义，本函数调整arr[s]的关键字，使arr[s...m]成为一个最大堆
        // s是最后一个非叶子节点
        int rc = arr[s];

        for(int j=2*s;j <= m;j = s*2){
            if(j<m && arr[j]<arr[j+1]) {
                // j为key较大的下标
                j++;
            }
            if(rc >= arr[j]) {
                break;
            }
            // 上移到父节点
            arr[s] = arr[j];
            s=j;
        }
        // 要放入的位置
        arr[s]=rc;
    }

    public void outPutArr(int i) {

        if(i <= arr[0]){
            System.out.println("outPutArr: " + arr[i]);
            // 左
            outPutArr(i*2);
            // 右
            outPutArr(i*2+1);
        }

    }

    public void heapSort(int[] arr) {

        // 对数组进行建堆操作，就是从最后一个非叶结点进行筛选的过程
        // 因为0没有使用，所以length-1
        for(int i=(arr.length-1)/2; i > 0; i--) {
            heapAdjust(arr,i,arr.length-1);
        }

        System.out.println("........建堆完成.............");

        outPutArr(1);
        for(int i=arr.length-1; i>1; i--){
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapAdjust(arr,1,i-1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HeapSort heapSor = new HeapSort();
        // 0下标放的是数组长度
        int[] arr = {7,23,45,9,40,73,12,49};
        heapSor.arr = arr;
        heapSor.heapSort(arr);

        for(int i :arr) {
            System.out.print(".." + i);
        }
        System.out.println("\n" +".......排序结束.......");
    }
}
