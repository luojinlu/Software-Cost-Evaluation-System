package com.example.demo.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class PageConfig {
    private static int PAGE_SIZE = 10;
    private static int PAGE_INDEX = 1;

    private int pageSize = PAGE_SIZE;
    private int pageIndex = PAGE_INDEX;

    private HashMap param = new HashMap();
}
