package com.ityang.basic.controller;

import com.ityang.basic.service.AlgorithmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/Algori")
@Api("算法学习")
@Slf4j
public class AlgorithmController {
    @Autowired
    private AlgorithmService service;

    @PostMapping("/merge")
    @ApiOperation("归并排序")
    @ResponseBody
    public <T> Object merge(@ApiParam(value = "arr", required = true) @RequestBody T[] arr) {
        service.mergeSort(arr, 0, arr.length - 1);
        return arr;
    }
}
