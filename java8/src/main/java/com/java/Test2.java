package com.java;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/8/28 17:41
 **/
public class Test2 {
    public static void main(String[] args) {
        /*选择排序思想
　　      第一次从下标为0的数字开始与后面的n-1个进行比较；找出最小或者最大的放在下标为0的这个位置；第二次从下标为1的开始比较；查询剩下的最大或者最小值；放在
        下标为1的位置；以此类推；直到排序完成*/
        int[] arr = {9,3,5,8,2};
        System.out.println("排序前：");
        Arrays.stream(arr).forEach(x->{
            System.out.print(x+" ");
        });

        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }

        System.out.println("\n排序后：");
        for (int num : arr){
            System.out.print(num+" ");
        }
    }
}
