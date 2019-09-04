package com.ityang.basic.service.impl;

import com.ityang.basic.service.Neo4jService;

import java.util.Map;
import java.util.Optional;

public class Neo4jServiceImpl implements Neo4jService {

    @Override
    public void addNode(Map map) {
        Runnable runnable = () -> System.out.println("Hello World");
        Optional.of(runnable);
    }
}
