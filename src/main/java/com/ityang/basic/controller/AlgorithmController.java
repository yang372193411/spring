package com.ityang.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/Algori")
@Api("算法学习")
public class AlgorithmController {

    @PostMapping("/merge")
    @ApiOperation("归并排序")
    public String merge(@ApiParam(value = "arr", required = true) @RequestBody int[] arr) {
        merge_sort_new(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
        return arr.toString();
    }

    private void merge_sort_new(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        /*分组，并对两个分组分别统计*/
        merge_sort_new(arr, start, mid);
        merge_sort_new(arr, mid + 1, end);
        merge_new(arr, start, mid, end);
    }

    private void merge_new(int[] arr, int start, int mid, int end) {
        int size = end - start + 1;
        if(size == 0){
            return;
        }
        int[] temp = new int[size];
        //复制数组中指定元素进行排序
        temp = Arrays.copyOfRange(arr, start, end+1);
        System.out.println(temp);
        int left = start, right = mid + 1; //left和right 分别指向两个子数组开始部分
        for (int index = start; index <= end; index++) {//index 代表对应原始数组的游标
            if (left > mid) {//如果左边的都已经排序完就只能从右边的数组中取
                arr[index] = temp[right - start];
                right++;
            } else if (right > end) {//如果右边的都已经排序完就只能从左边的数组中取
                arr[index] = temp[left - start];
                left++;
            } else if (temp[left - start] < temp[right - start]) {
                arr[index] = temp[left - start];
                left++;
            } else {
                arr[index] = temp[right - start];
                right++;
            }
        }
    }
}
