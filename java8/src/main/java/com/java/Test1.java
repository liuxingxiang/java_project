package com.java;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/8/28 15:32
 **/
public class Test1 {

    public static void main(String[] args) {
        /*比较相邻两个数据，大的往下沉，小的往上浮；

　　比如：int[] arr = {8,2,5}根据冒泡排序思想依次比较结果如下

　　第一遍：拿8和2比 发现8>2则把8往后移-->{2,8,5}  再用8和5比  8>5后移---->{2,5,8}*/

        int[] arr = {9,3,5,8,2};
        System.out.println("排序前：");
        Arrays.stream(arr).forEach(x->{
            System.out.print(x+" ");
        });

        for (int i=0;i<arr.length-1;i++) {       //外层循环控制次数(需要遍历的数字个数)
            for (int j=0;j<arr.length-1-i;j++) { //内层循环控制（当前数字）需要比较的次数
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println("\n排序后：");
        for (int num : arr){
            System.out.print(num+" ");
        }
    }
}
