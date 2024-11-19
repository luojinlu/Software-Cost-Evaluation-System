package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Dashboard;
import com.example.demo.mapper.DashboardMapper;
import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardImpl extends ServiceImpl<DashboardMapper, Dashboard> implements DashboardService {

    @Autowired
    private DashboardMapper dashboardMapper;
}
