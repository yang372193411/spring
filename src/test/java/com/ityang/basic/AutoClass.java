package com.ityang.basic;

import org.junit.Test;

import java.util.Arrays;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AutoClass {

    @Test
    public void AutoCreate() {
        int[] list = new int[]{2,3,6,8,1,4,5,7};
        //归并算法 nlog算法
        mergeSort(list);

    }

    public static void mergeSort(int[] list){
        int[] clist = Arrays.copyOf(list, list.length);
        int left = list.length/2;
        int right = list.length - left;
        System.out.println(left);
        System.out.println(right);
        if(left > right){
            return;
        }
    }

}
